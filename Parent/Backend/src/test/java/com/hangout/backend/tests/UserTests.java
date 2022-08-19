package com.hangout.backend.tests;

import com.hangout.backend.EntityRepo.UserRepo;
import com.hangout.common.entity.Role;
import com.hangout.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;
import java.util.LinkedList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserTests {

    @Autowired
    UserRepo userRepo;
    @Autowired
    TestEntityManager entityManager;
    @Test
    public void CreateUserTest(){
        User user = new User("ck@gmail.com", "pas");
        var list = getRoles();
        user.addRoles(list);
        User savedUser = userRepo.save(user);
        Assert.isTrue(savedUser.getId() > 0 , "");
    }

    @Test
    public void CreateUserTest2(){
        User user = new User("ck2@gmail.com", "pas");
        var list = getRoles();
        user.addRoles(list);
        User savedUser = userRepo.save(user);
        Assert.isTrue(savedUser.getId() > 0 , "");
    }



    private List<Role> getRoles(){
      return new LinkedList<>(
            List.of( entityManager.find (Role.class, 2),
                    entityManager.find (Role.class, 5))
        );
    }
}
