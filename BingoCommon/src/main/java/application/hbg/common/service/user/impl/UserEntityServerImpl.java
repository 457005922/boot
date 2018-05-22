package application.hbg.common.service.user.impl;


import application.hbg.common.model.user.UserEntity;
import application.hbg.common.repository.user.UserEntityRepository;
import application.hbg.common.service.user.UserEntityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServerImpl  implements UserEntityServer{

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserEntity create(UserEntity userEntity){
        userEntityRepository.save(userEntity);
        return userEntity;
    }
    @Override
    public List<UserEntity> select(){
        List<UserEntity> entities =  userEntityRepository.findAll();
        return entities;
    }

    @Override
    public void del(String id){
        userEntityRepository.delete(id);
    }
}
