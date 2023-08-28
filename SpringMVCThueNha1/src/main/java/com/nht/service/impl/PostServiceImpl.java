/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.service.impl;

import com.nht.pojo.Post;
import com.nht.repository.PostRepository;
import com.nht.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 * @author nitro 5
 */
@Service
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postRepo;
  
    @Override
    public List<Post> getPostsAllList() {
        
        return this.postRepo.getPostsAllList();
    }

    
    @Override
    public List<Post> getPostById(int idPost) {
        return this.getPostById(idPost);
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
    
}
