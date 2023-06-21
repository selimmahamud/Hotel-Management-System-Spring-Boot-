package org.idb.Tourism.restcontroller;

import org.idb.Tourism.entity.Location;
import org.idb.Tourism.entity.Role;
import org.idb.Tourism.entity.User;
import org.idb.Tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class UserRestController {
    @Autowired
    UserService userService;


    @GetMapping("/user/all")
    public List<User> allUser(){
        return userService.getAllUser();
    }

    @PostMapping("/usersave")
    public void addUser(@RequestBody User u){


        userService.saveUser(u);

    }

    public String allUser(User u, Model m){
        m.addAttribute("userList", userService.getAllUser());
        return "user-list";
    }


    public String editUser(@PathVariable("uId") Integer uId, Model m){
        User u = userService.getById(uId);
        m.addAttribute("user",u);
        return "user-list";
    }


    public String deleteUser(@PathVariable("uId") Integer uId, Model m){
        userService.deleteUser(uId);
        return "redirect/user-list";
    }
}
