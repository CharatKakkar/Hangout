package com.hangout.backend.security;

import com.hangout.backend.EntityRepo.UserRepo;
import com.hangout.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class HangoutUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

          User user =   userRepo.getUserByEmail(s);
          if(user != null)
             return new UserDetailsImpl(user);
          throw new UsernameNotFoundException("Username not found" + s);
    }
}
