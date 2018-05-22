package application.hbg.common.service.user;


import application.hbg.common.model.user.UserEntity;

import java.util.List;

public interface UserEntityServer {
    UserEntity create(UserEntity userEntity);

    List<UserEntity> select();

    void del(String id);
}
