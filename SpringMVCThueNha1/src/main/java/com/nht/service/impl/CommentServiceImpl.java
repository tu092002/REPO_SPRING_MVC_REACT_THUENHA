/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.service.impl;

import com.nht.pojo.Comment;
import com.nht.pojo.User;
import com.nht.repository.CommentRepository;
import com.nht.repository.UserRepository;
import com.nht.service.CommentService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author nitro 5
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Comment> getComments(int idPost) {
        return this.commentRepo.getComments(idPost);
    }

    @Override
    public Comment addComment(Comment c) {
        c.setCreatedDate(new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User u = this.userRepo.getUserByUsername(authentication.getName());

        c.setIdUser(u);

        return this.commentRepo.addComment(c);
    }
}
