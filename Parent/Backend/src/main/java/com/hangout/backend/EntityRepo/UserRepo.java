package com.hangout.backend.EntityRepo;

import com.hangout.common.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;
import java.util.List;

public interface UserRepo extends PagingAndSortingRepository<User, Id> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u")
    public List<User> getAllUsers();

}
