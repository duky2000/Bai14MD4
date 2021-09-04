package demoSecurity.repository;

import demoSecurity.model.ApUser;
import org.springframework.data.repository.CrudRepository;

public interface IApUserRepository extends CrudRepository<ApUser, Long> {
    ApUser findAllByUserName(String name);
}
