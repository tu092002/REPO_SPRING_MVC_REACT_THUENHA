/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.service.impl;

import com.cloudinary.Cloudinary;
import java.security.Principal;

import com.cloudinary.utils.ObjectUtils;
import com.nht.components.JwtService;
import com.nht.pojo.Post;
import com.nht.pojo.User;
import com.nht.repository.PostRepository;
import com.nht.repository.UserRepository;
import com.nht.repository.impl.PostRepositoryImpl;
import com.nht.service.PostService;
import com.nht.service.UserService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nitro 5
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Post> getPostsAllList() {

        return this.postRepo.getPostsAllList();
    }

    @Override
    public Post getPostById(int idPost) {
        return this.postRepo.getPostById(idPost);
    }

    @Override
    public List<Post> getPostByAddress(String Address) {
        return this.postRepo.getPostByAddress(Address);
    }

    @Override
    public List<Post> getPostByGiaTien(double minPrice, double maxPrice) {
        return this.postRepo.getPostByGiaTien(minPrice, maxPrice);
    }

    @Override
    public int countPosts() {
        return this.postRepo.countPosts();
    }

    @Override
    public List<Post> getPosts(Map<String, String> params) {
        return this.postRepo.getPosts(params);
    }

    @Override
    public Post addPost(Map<String, String> params, MultipartFile imgPost) {
        Post u = new Post();
        u.setTitlePost(params.get("titlePost"));
        u.setGiaTien(Double.parseDouble(params.get("giaTien")));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = this.userRepo.getUserByUsername("admin");
//        User currentUser = this.userRepo.getUserByUsername(authentication.getName());
        System.out.println("Current user: " + authentication.getName());

        u.setIdUser(currentUser);
        u.setAddressPost(params.get("addressPost"));

        if (!imgPost.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(imgPost.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setImgPost(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(PostRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.postRepo.addPost(u);
        return u;
    }

    @Override
    public boolean deletePost(int id) {
        return this.postRepo.deletePost(id);
    }

    @Override
    public boolean updateStatusPost(int id) {
        return this.postRepo.updateStatusPost(id);
    }
}
