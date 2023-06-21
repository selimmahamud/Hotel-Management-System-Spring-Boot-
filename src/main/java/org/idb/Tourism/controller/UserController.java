package org.idb.Tourism.controller;

import org.idb.Tourism.entity.User;
import org.idb.Tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user-form")
    public String addUserForm(Model m){
        m.addAttribute("user", new User());
        m.addAttribute("userList", userService.getAllUser());
        return "user-reg-form";
    }
    @RequestMapping("/user-save")
    public String addUser(User u, Model m){
        userService.saveUser(u);
        return "redirect:/user-list";
    }
    @RequestMapping("/user-list")
    public String allUser(User u, Model m){
        m.addAttribute("userList", userService.getAllUser());
        return "user-list";
    }

    @RequestMapping("/user-edit/{uId}")
    public String editUser(@PathVariable("uId") Integer uId, Model m){
        User u = userService.getById(uId);
        m.addAttribute("user",u);
        return "user-list";
    }

    @RequestMapping("/user-delete/{uId}")
    public String deleteUser(@PathVariable("uId") Integer uId, Model m){
        userService.deleteUser(uId);
        return "redirect/user-list";
    }
}
