package application.hbg.controller.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述:
 *      测试 activeMQ
 * @author hubugui
 * @version 0.1
 * @email hubugui@izjjf.cn
 * @since  2018/4/28
 */
@Component
@EnableScheduling
public class ActiveMQDemoProvider {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    private static int count = 0;

    @Scheduled(fixedDelay = 5000) // 每5s执行1次-测试使用
    public void send() {

        // 这里定义了Queue的key
        Destination destination = new ActiveMQQueue("TEST_QUEUE_LOG");
        String message = "Send AMQ Test ..." + count;
        System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "]" + message);
        count++;
        //生产者/消费者模式
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
