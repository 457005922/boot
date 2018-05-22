package application.hbg.controller.user;


import application.hbg.common.model.user.UserEntity;
import application.hbg.common.service.user.UserEntityServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户管理")
@RestController
public class UserController {

    @Autowired
    private UserEntityServer userEntityServer;


    @ApiOperation(value = "添加用户",notes = "添加用户")
    @PostMapping("/create")
    public UserEntity create(UserEntity userEntity){
        return  userEntityServer.create(userEntity);
    }

}
