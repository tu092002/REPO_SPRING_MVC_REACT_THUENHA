/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.service;

import com.nht.pojo.Comment;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author nitro 5
 */
public interface CommentService {

    List<Comment> getComments(int idPost);

    Comment addComment(Comment c);
}
