package com.hangout.backend.EntityRepo;

import com.hangout.common.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface UserRepo extends CrudRepository<User, Id> {
}
