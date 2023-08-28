/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.service;

import com.nht.pojo.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nitro 5
 */
public interface PostService {

    List<Post> getPostsAllList();

    List<Post> getPosts(Map<String, String> params);

    List<Post> getPostById(int idPost);

    List<Post> getPostByAddress(String Address);

    List<Post> getPostByGiaTien(double minPrice, double maxPrice);

    int countPosts();
}
