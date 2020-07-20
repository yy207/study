package cn.springboot.rabbitmq.two.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.10.10 10:48
 */
@Component
@RabbitListener(queues = "q_topic_message")
public class TopicReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
