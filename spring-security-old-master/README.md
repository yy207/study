### Spring Security

Spring Security主要包含两个部分：用户认证和用户授权，本质上是Filter过滤器，对请求进行过滤

![](C:/Users/peish/Desktop/知识点/image/spring-security.png)

![](C:/Users/peish/Desktop/知识点/image/spring-security认证流程.png)

> 用户认证

如果访问的登录路径(/auth/login)，那么执行登录授权存储token操作，之后发放该请求；

如果访问不是则验证请求头中的token获取权限，之后发放该请求

```
如果系统的模块众多，每个模块都需要就行授权与认证，所以我们选择基于token的形式进行授权与认证，用户根据用户名密码认证成功，然后获取当前用户角色的一系列权限值，并以用户名为key;权限列表为value的形式存入redis缓存中
根据用户名相关信息生成token返回，浏览器将token记录到cookie中，每次调用api接口都默认将token携带到header请求头中，Spring-security解析header头获取token信息，解析token获取 当前用户名，根据用户名就可以从redis中获取权限列表，这样Spring -security就能够判断当前请求是否有权限访问
```



> 用户授权

