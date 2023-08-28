/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.nht.pojo.Post;
import com.nht.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nitro 5
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiPostController {
    @Autowired
    private PostService postService;
    
    @GetMapping("/posts/")
    public ResponseEntity<List<Post>> list(@RequestParam Map<String,String> params) {
        return new ResponseEntity<>(this.postService.getPosts(params), HttpStatus.OK);
    }
   
}
