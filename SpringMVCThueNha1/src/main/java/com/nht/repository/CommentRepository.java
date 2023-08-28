/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.repository;

import com.nht.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nitro 5
 */

public interface CommentRepository {
     public List<Comment> getCommentsByPost(Map<String, String> params);
}
