package cn.springboot.rabbitmq.one.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.10.10 8:57
 */
@Component
@RabbitListener(queues = "message")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver  : " + message);
    }

}
