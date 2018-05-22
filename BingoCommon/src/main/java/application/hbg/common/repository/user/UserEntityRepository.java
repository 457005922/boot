package application.hbg.common.repository.user;

import application.hbg.common.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository  extends PagingAndSortingRepository<UserEntity,String> ,JpaSpecificationExecutor<UserEntity>,JpaRepository<UserEntity,String>{
}
