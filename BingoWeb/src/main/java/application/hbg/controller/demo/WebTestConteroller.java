package application.hbg.controller.demo;

import application.hbg.common.demo.CommonTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
