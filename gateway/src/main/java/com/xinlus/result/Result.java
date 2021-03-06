package com.xinlus.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private boolean status = true;
    private Integer statusCode;
    private String message;
    private T data;

    @JsonIgnore
    private String objId;

    public Result() {
    }

    public Result(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Result(ResultTypeEnum type) {
        this.statusCode = type.getStatusCode();
        this.message = type.getMessage();
    }

    public Result(Integer statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public Result(ResultTypeEnum type, T data) {
        this.statusCode = type.getStatusCode();
        this.data = data;
        this.message = type.getMessage();
    }

    public Result(ResultTypeEnum type, String message, T data) {
        this.statusCode = type.getStatusCode();
        this.data = data;
        this.message = message;
    }

    public Result(boolean status, Integer statusCode, String message, T data) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>(ResultTypeEnum.SUCCESS);
        result.setStatus(true);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>(ResultTypeEnum.SUCCESS, data);
        result.setStatus(true);
        return result;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<T>(ResultTypeEnum.SUCCESS.getStatusCode(), msg);
        result.setStatus(true);
        return result;
    }

    public static <T> Result<T> success(String message, T data) {
        Result<T> result = new Result<T>(ResultTypeEnum.SUCCESS, message, data);
        result.setStatus(true);
        return result;
    }

    public static <T> Result<T> fail(String message) {

        Result<T> result = new Result<T>();

        result.setStatus(false);

        result.setMessage(message);

        return result;

    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<T>(ResultTypeEnum.SERVICE_ERROR.getStatusCode(), message);

        result.setStatus(false);

        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<T>(code, message);

        result.setStatus(false);

        return result;
    }

    public static <T> Result<T> error(Integer code, String message, T data) {
        Result<T> result = new Result<T>(code, message, data);

        result.setStatus(false);

        return result;
    }

    @Getter
    public enum ResultTypeEnum {
        /**
         * ????????????
         */
        // USER_ALREADY_REG("40001", "?????????????????????"),
        // TWO_PWD_NOT_MATCH("405", "???????????????????????????"),
        NOT_LOGIN(40001, "?????????????????????"),

        NOT_COMPLETION(40002, "?????????????????????"),

        METHOD_NOT_ALLOWED(40003, "?????????????????????"),

        // USER_NOT_EXISTED("400", "???????????????"),
        // ACCOUNT_FREEZED("401", "???????????????"),
        // OLD_PWD_NOT_RIGHT("402", "??????????????????"),

        SUCCESS(00000, "????????????"),

        PARAM_ERROR(40000, "????????????"),

        FILE_SIZE_ERROR(70000, "????????????????????????,??????10M"),

        SERVICE_ERROR(50000, "????????????"),

        SYS_ERROR(60000, "????????????"),
        ;

        private final Integer statusCode;

        private final String message;

        ResultTypeEnum(Integer statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }
    }
}
