package com.hangout.backend.services;

import com.hangout.backend.EntityRepo.UserRepo;
import com.hangout.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers(){
       return userRepo.getAllUsers();
    }

    public boolean isUserExist(String email){
       return userRepo.getUserByEmail(email) == null ? false : true ;
    }

}
