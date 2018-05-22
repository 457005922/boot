package application.hbg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 描述:
 *
 * @author 花满楼
 * @version 0.1
 * @email huamanlou@izjjf.cn
 * @since 2017-04-30 03:01
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * 收银系统API
     * @return
     */
    @Bean
    public Docket posApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统API")
                .apiInfo(
                    new ApiInfoBuilder()
                    .title("系统API文档")
                    .description("系统API文档&nbsp;&nbsp;&nbsp;&nbsp;JSON格式化工具：http://www.bejson.com/jsonviewernew/")
                    .version("1.0.0")
                    .build()
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("application.hbg.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}