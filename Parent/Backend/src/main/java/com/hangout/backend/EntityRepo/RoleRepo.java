package com.hangout.backend.EntityRepo;

import com.hangout.common.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

}
