package cn.springboot.rabbitmq;

import cn.springboot.rabbitmq.three.sender.FanoutSender;
import cn.springboot.rabbitmq.two.sender.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

//    @Autowired
//    private Sender sender;
//
//    @Test
//    public void message() throws Exception {
//        for (int i=0;i<100;i++){
//            sender.send(i);
//            Thread.sleep(300);
//        }
//    }

//    @Autowired
//    private TopicSender topicSender;
//
//    @Test
//    //send1方法会匹配到topic.#和topic.message，两个Receiver都可以收到消息
//    public void send1() throws Exception {
//        topicSender.send1();
//    }
//
//    @Test
//    //send2只有topic.#可以匹配所有只有Receiver2监听到消息。
//    public void send2() throws Exception {
//        topicSender.send2();
//    }


    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void send1() throws Exception {
        fanoutSender.send();
    }

}
