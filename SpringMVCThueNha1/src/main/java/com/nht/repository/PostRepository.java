/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.repository;

import com.nht.pojo.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nitro 5
 */
public interface PostRepository {

    public List<Post> getPostsAllList();

    public List<Post> getPosts(Map<String, String> params);

    public Post getPostById(int id);

    public List<Post> getPostByAddress(String Address);

    public List<Post> getPostByGiaTien(double minPrice, double maxPrice);

    public int countPosts();

    public Post addPost(Post u);

    public boolean deletePost(int id);

    public boolean updateStatusPost(int id);

}
