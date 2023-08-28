/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.nht.pojo.Comment;
import com.nht.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nitro 5
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCommentController {

    @Autowired
    private CommentService commentService;

//    @DeleteMapping("user/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable(value = "id") int id) {
//        this.userService.delete(id);
//    }

    @GetMapping("/comments/")
    public ResponseEntity<List<Comment>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.commentService.getCommentsByPost(params), HttpStatus.OK);
    }
}
