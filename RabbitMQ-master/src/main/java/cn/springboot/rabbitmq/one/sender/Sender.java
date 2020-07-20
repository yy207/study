package cn.springboot.rabbitmq.one.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.10.10 8:56
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "message :" + i;
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
        rabbitTemplate.convertAndSend("message", context);
    }
}
