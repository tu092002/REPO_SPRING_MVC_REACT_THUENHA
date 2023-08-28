/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.formatter;

import com.nht.pojo.Post;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nitro 5
 */
public class PostFormatter implements  Formatter<Post>{

    @Override
    public String print(Post post, Locale locale) {
        return String.valueOf(post.getIdPost());
        
    }
    

    @Override
    public Post parse(String idPost, Locale locale) throws ParseException {
        int id =  Integer.parseInt(idPost);
        return new Post(id);
    }
    
    
}
