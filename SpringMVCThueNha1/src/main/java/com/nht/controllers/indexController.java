/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.nht.pojo.Post;
import com.nht.repository.PostRepository;
import com.nht.repository.UserRepository;
import com.nht.service.PostService;
import com.nht.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nitro 5
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")

public class indexController {

    @Autowired
    private UserService userService;
    @Autowired

    private PostService postService;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepository postRepo;

    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
//        model.addAttribute("posts", this.postService.getPosts());
          List<String> listRole = new ArrayList<>();
          listRole.add("ROLE_USER");
          listRole.add("ROLE_ADMIN");
          listRole.add("ROLE_CHUTRO");
          model.addAttribute("listRole", listRole);
           List<Integer> listActive = new ArrayList<>();
          listActive.add(1);
          listActive.add(2);
          model.addAttribute("listActive", listActive);
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("users", this.userService.getAllUser(params));
        model.addAttribute("posts", this.postService.getPosts(params));

        int count = this.userRepo.countUsers();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE").toString());
        model.addAttribute("page", Math.ceil(count * 1.0 / pageSize));
        return "index";
    }

    @RequestMapping("/posts")
    public String post(Model model, @RequestParam Map<String, String> params) {
//        model.addAttribute("users", this.userService.getAllUser(params));
        model.addAttribute("posts", this.postService.getPosts(params));

//        int count = this.postService.countPosts();
//        int pageSize = Integer.parseInt(env.getProperty("PAGE_SIZE").toString());
//        model.addAttribute("pages", Math.ceil(count*1.0/pageSize));
        return "posts";
    }
    
    

   

}
