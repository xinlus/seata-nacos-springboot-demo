| 版本号 | 内容     | 修改人 | 修改时间   |
| ------ | -------- | ------ | ---------- |
| 1.0.0  | 初版定稿 | xinlus   | 2022/07/07 |

[toc]
#springboot 集成 seata1.5.1

## 一、框架版本
#### 1.1、spring-cloud-dependencies: Hoxton.SR12
#### 1.2、spring-boot-dependencies: 2.2.13.RELEASE
#### 1.3、spring-cloud-alibaba-dependencies: 2.2.7.RELEASE
#### 1.4、seata-spring-boot-starter: 1.5.1
#### 1.5、nacos-client: 2.0.4
#### 1.6、seata-server-client: 1.5.1

## 二、seata说明
#### 2.1、seata客户端[seata1.5.1](doc/seata1.5.1.7z)
#### 2.2、注意seata启动配置conf/application.yml
##### 2.2.1、两处nacos的地址 server-addr: http://127.0.0.1:8848
#### 2.3、seata-server中数据库驱动我使用的是8.0以上版本如果需要更换5.0,可以在target文件夹里替换，
          \seata1.5.1\target\mysql5版本文件替换\seata-server.jar -> \seata1.5.1\target\seata-server.jar
## 三、seata nacos客户端下载地址
#### 3.1、[百度云网盘]链接：https://pan.baidu.com/s/1EDE-40rBRsgt2bPkAhTA6A?pwd=ok6x 提取码：ok6x
