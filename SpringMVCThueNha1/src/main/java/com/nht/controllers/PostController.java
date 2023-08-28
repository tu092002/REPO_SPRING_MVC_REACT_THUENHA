/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.cloudinary.Cloudinary;
import com.nht.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author nitro 5
 */
@Controller
public class PostController {
    
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/admin/posts")
    public String List(Model model) {
        model.addAttribute("post", new Post()); 
        return "post";      
    }
    
//    @PostMapping("/admin/posts")
//    public String add(@ModelAttribute(value = "post") Post post){
//        this.cloudinary.uploader(post.getFile().getBytes(),
//                ObjectUtils.asMap("resource_type", "auto"));
//                    
//        
//    }
    
    
    
    
}



