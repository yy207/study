package cn.springboot.rabbitmq.three.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: _Cps
 * Date: 2019.10.10 11:34
 */
@Component
@RabbitListener(queues = "q_fanout_C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("CReceiver  : " + hello + "/n");
    }

}
