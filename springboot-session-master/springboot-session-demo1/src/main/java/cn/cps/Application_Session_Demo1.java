package cn.cps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @EnableRedisHttpSession 实现session共享
 */
@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=30,redisNamespace = "tl")
public class Application_Session_Demo1
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application_Session_Demo1.class);
    }
}
