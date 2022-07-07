package com.xinlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinlus.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xinlus@126.com
 * @since 2022-07-06
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    int updateAccountAmountById(@Param("addAmount") BigDecimal addAmount,
                                @Param("id") Integer id);

}
