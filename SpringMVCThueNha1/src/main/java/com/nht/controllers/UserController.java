/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.nht.pojo.User;
import com.nht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nitro 5
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String list(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @GetMapping("/user/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.userService.getUserById(id));

        return "user";
    }

    @PostMapping("/user")
    public String add(@ModelAttribute(value = "user") User u) {
        if (this.userService.addOrUpdateUser(u) == true) {
            return "redirect:/";
        }   
        return "user";
    }
}
