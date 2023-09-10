/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.repository;

import com.nht.pojo.Comment;
import java.util.List;

/**
 *
 * @author huu-thanhduong
 */
public interface CommentRepository {
    List<Comment> getComments(int idPost);
    Comment addComment(Comment c);
    
}
