package com.hangout.backend.tests;

import com.hangout.backend.EntityRepo.UserRepo;
import com.hangout.common.entity.Role;
import com.hangout.common.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
        User user = new User("charat", "kakkar", "ck@gmail.com", "pas", true);
        List<Role> list = getRoles();
        user.addRoles(list);
        User savedUser = userRepo.save(user);
        Assert.isTrue(savedUser.getId() > 0 , "");
    }


    @Test
    public void CreateUserTest_admin2(){
        User user = new User("charat", "kakkar", "ck2@gmail.com", "pas", true);
        List<Role> list = getRoles();
        user.addRoles(list);
        User savedUser = userRepo.save(user);
        Assert.isTrue(savedUser.getId() > 0 , "");
    }

    @Test
    public void CreateUserTest2(){
        User user = new User("Sanya", "Singh", "ss@gmail.com", "pas", false);
        user.addRoles(getRoles());
        User savedUser = userRepo.save(user);
        Assert.isTrue(savedUser.getId() > 0 , "");
    }

    @Test
    public void CreateUserTest_Sales(){
        User user = new User("Sales", "Team", "sales@gmail.com", "pas", true);
        user.addRoles(getSalesRole());
        User savedUser = userRepo.save(user);
        Assert.isTrue(savedUser.getId() > 0 , "");
    }



    private List<Role> getRoles(){
      return new LinkedList<>(
            List.of( entityManager.find (Role.class, 1),
                     entityManager.find (Role.class, 2),
                     entityManager.find (Role.class, 3))
        );
    }

   //GetSales role only
    private List<Role> getSalesRole(){
        return new LinkedList<>(
                List.of( entityManager.find (Role.class, 1))

        );
    }
}
