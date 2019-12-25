package com.hp.controller;

import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("word")
    @ResponseBody
    public String hello(){
        System.out.println("haha");
        return "success";
    }

    //    @RequestMapping(value = "user/{id}",method =RequestMethod.GET )
    @GetMapping("/{id}")
    @ResponseBody
    public User queryById(@PathVariable("id") Long i){
        System.out.println(i);
        User user=userService.queryUserById(i);
        return user;
    }

    @GetMapping("/del/{ids}")
    @ResponseBody
    public String deleteUserById(@PathVariable("ids") Long id){
         userService.deleteUserById(id);
         return "success";
    }

    @GetMapping("list")
    public String queryAllUser(Model model){
        List<User> list=userService.queryAll();
        model.addAttribute("users",list);
        return "item";
    }

}
