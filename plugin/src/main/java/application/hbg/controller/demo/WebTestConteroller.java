package application.hbg.controller.demo;

import application.hbg.common.demo.CommonTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.network.jms.JmsMesageConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(description = "测试swagger")
@RestController
public class WebTestConteroller {

    @ApiOperation(value = "测试swagger",notes = "测试swagger")
    @GetMapping(value = "/hello")
    public String test1() {
        CommonTest hello  = new CommonTest();
        hello.sayHello();
        return "spring boot multiple modules test";
    }
}
