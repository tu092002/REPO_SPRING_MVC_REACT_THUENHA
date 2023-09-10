/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.service;

import com.nht.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nitro 5
 */
public interface UserService extends UserDetailsService {

    User getUserByUsername(String username);

    List<User> getAllUser(Map<String, String> params);

    int countUsers();

    public boolean addOrUpdateUser(User u);

    public User getUserById(int id);

    public boolean deleteUser(int id);

    boolean authUser(String username, String password);

    public User addUser(Map<String, String> params, MultipartFile avatar);

}
