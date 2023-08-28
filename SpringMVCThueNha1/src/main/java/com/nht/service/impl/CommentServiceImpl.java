/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.service.impl;

import com.nht.pojo.Comment;
import com.nht.repository.CommentRepository;
import com.nht.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author nitro 5
 */
@Service
public class CommentServiceImpl implements  CommentService{
    @Autowired
    private CommentRepository  commentRepo;
    

    @Override
    public List<Comment> getCommentsByPost(Map<String, String> params) {

            return this.commentRepo.getCommentsByPost(params);
    }
}
