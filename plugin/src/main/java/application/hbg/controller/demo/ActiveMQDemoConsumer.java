package application.hbg.controller.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ActiveMQDemoConsumer {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    /**
     * 使用@JmsListener注解来监听指定的某个队列内的消息
     **/
    @JmsListener(destination = "TEST_QUEUE_LOG")
    public void removeMessage(String msg) {
        System.out.println("["+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+"]Receive:"+msg);
    }
}
