/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nht.formatter;

import com.nht.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nitro 5
 */
public class UserFormatter implements  Formatter<User>{

    @Override
    public String print(User user, Locale locale) {
        return String.valueOf(user.getIdUser());
        
    }   
    

    @Override
    public User parse(String idUser, Locale locale) throws ParseException {
        int id =  Integer.parseInt(idUser);
        return new User(id);
    }
    
    
}
