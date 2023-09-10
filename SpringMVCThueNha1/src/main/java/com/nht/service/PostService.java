/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.service;

import com.nht.pojo.Post;
import com.nht.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nitro 5
 */
public interface PostService {

    List<Post> getPostsAllList();

    List<Post> getPosts(Map<String, String> params);

    public Post getPostById(int id);

    List<Post> getPostByAddress(String Address);

    List<Post> getPostByGiaTien(double minPrice, double maxPrice);

    int countPosts();

    public Post addPost(Map<String, String> params, MultipartFile imgPost);

    public boolean deletePost(int id);

    public boolean updateStatusPost(int id);
}
