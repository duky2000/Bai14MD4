package demoSecurity.repository;

import demoSecurity.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepository extends CrudRepository<Role,Long> {
}
