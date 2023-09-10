/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.cloudinary.Cloudinary;
import com.nht.pojo.Post;
import com.nht.repository.PostRepository;
import com.nht.repository.UserRepository;
import com.nht.service.PostService;
import com.nht.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nitro 5
 */
@Controller
public class PostController {

    @Autowired
    private Cloudinary cloudinary;
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

    @GetMapping("/post")
    public String List(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("posts", this.postService.getPosts(params));
        return "post";
    }

//    @RequestMapping(value = "/post/{id}", method = RequestMethod.PUT)
//    @CrossOrigin
//    public String Duyet(@PathVariable(value = "idPost") int id, Model model) {
//
//        try {
//            this.postService.updateStatusPost(id);
//            model.addAttribute("message", "Duyệt bài thành công");
//
//        } catch (Exception e) {
//            model.addAttribute("error", "Lỗi khi cập nhật");
//        }
//        return "post";
//    }

}
