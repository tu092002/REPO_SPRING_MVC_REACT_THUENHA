/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.controllers;

import com.nht.pojo.Comment;
import com.nht.pojo.Post;
import com.nht.pojo.User;
import com.nht.service.CommentService;
import com.nht.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/")
    public ResponseEntity<List<Post>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.postService.getPosts(params), HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.postService.deletePost(id);
    }

//    @PutMapping("/post/{id}/status")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void duyetPost(@PathVariable(value = "id") int id) {
//        this.postService.updateStatusPost(id);
//    }

    @PutMapping("/post/{id}/status")
    @ResponseBody
    public ResponseEntity<String> duyetPost(@PathVariable int id, @RequestBody Map<String, Object> updateData) {
        // Trích xuất giá trị price từ dữ liệu JSON
        Object statusObject = updateData.get("status");
        if (statusObject == null) {
            return new ResponseEntity<>("Missing status in JSON post", HttpStatus.BAD_REQUEST);
        }

        // Chuyển đổi giá trị price thành kiểu số
        try {
            int status = Integer.parseInt(statusObject.toString());
            // TODO: Cập nhật giá sản phẩm với productId và giá mới (price)
            this.postService.updateStatusPost(id);
            return new ResponseEntity<>("post status updated successfully", HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Invalid post status format", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/posts/{idPost}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Post> Details(@PathVariable(value = "idPost") int id) {
        this.postService.getPostById(id);
        return new ResponseEntity<>(this.postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/posts/{idPost}/comments/")
    @CrossOrigin
    public ResponseEntity<List<Comment>> listComments(@PathVariable(value = "idPost") int id) {
        return new ResponseEntity<>(this.commentService.getComments(id), HttpStatus.OK);
    }

    @PostMapping(path = "/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment c = this.commentService.addComment(comment);

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @PostMapping(path = "/posts/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Post> addPost(@RequestParam Map<String, String> params, @RequestPart MultipartFile imgPost) {
        Post post = this.postService.addPost(params, imgPost);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
}
