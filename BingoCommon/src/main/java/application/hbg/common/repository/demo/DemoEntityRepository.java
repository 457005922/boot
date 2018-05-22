package application.hbg.common.repository.demo;


import application.hbg.common.model.demo.DomeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoEntityRepository extends MongoRepository<DomeEntity,String> {
}
