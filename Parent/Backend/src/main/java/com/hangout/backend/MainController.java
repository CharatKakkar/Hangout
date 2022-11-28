package com.hangout.backend;

import com.hangout.backend.services.UserService;
import com.hangout.common.entity.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

/*    @RequestMapping(path = "/registerUser", method = RequestMethod.POST)
   // @PostMapping("/registerUser")
    public String registerPage(HttpServletRequest request, String email, String fname, String lname, String password){
        // model.addAttribute("user" , new User());
         String email2 =  request.getParameter("email");
        System.out.println(email);
        return "register";
    }*/


    @PostMapping("/registerUser")
    public String registerPage(User user){
        return "register";
    }

    @GetMapping("/users")
    public String usersPage(Model model){

         List<User> users  = userService.getAllUsers();
         model.addAttribute("users", users);
        return "users";
    }

  //  @RequestMapping(path = "/checkuser", method = RequestMethod.GET)
  //  public String CheckUsername(HttpServletRequest request, Model model){
     @PostMapping("/checkuser")
     public String CheckUsername(User user, Model model){

       // String email =  request.getParameter("email");
        String email  =  user.getEmail();

        if(userService.isUserExist(email)){
            model.addAttribute("message" , "Email already registered");
        }
        else
            model.addAttribute("message" , "Email is accepted");
        model.addAttribute("user" , user);

        return "register";

    }


}
