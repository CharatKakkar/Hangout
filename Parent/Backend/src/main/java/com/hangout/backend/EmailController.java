package com.hangout.backend;


import com.hangout.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmailController {
    @Autowired
    UserService userService;

    @GetMapping("/checkemails/{email}")
    public Map<String,String> checkEmails(@PathVariable String email){
        Map<String,String> map = new HashMap();
        map.put("message", !userService.isUserExist(email) ? "Email is available" : "Email exists");
        return map;
    }

}
