

#### 解决的是同一个浏览器 不同服务(Tomcat)  Session共享

> 是以sessionID来区分

> Session失效时期是从最后一次请求计算，一但重新请求失效时间将重新刷新

> 浏览器关闭不代表Session关闭，是因为新打开的浏览器，找不到服务端返回的JSESESSION



> 只需要加入Redis数据库配置，@EnableRedisHttpSession注解以及Manve依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
</dependency>
```



