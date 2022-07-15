FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
RUN rm -f /etc/localtime &&  ln -s ../usr/share/zoneinfo/Asia/Shanghai /etc/localtime
EXPOSE 8080/tcp
ENTRYPOINT ["java","-noverify","-XX:TieredStopAtLevel=1","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap",\
"-DRUNDISCOVERY_ADDR=${NACOS_HOSTNAME}:${NACOS_PORT}",\
"-DRUNENV=${ENV}",\
"-cp","app:app/lib/*","com.xinlus.PurchaseOrderApplication"]