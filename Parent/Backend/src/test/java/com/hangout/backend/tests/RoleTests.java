package com.hangout.backend.tests;

import com.hangout.backend.EntityRepo.RoleRepo;
import com.hangout.common.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleTests {

    @Autowired
    RoleRepo roleRepo;

    @Test
    public void CreateRoleTest(){

        Role role = new Role("Admin","Admin role");
        Role savedRole  =  roleRepo.save(role);
        Assert.isTrue(savedRole.getId() > 0, "Id is not gt 0");

    }
}
