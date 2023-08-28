/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nht.repository;

import com.nht.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nitro 5
 */
public interface UserRepository {

    User getUserByUsername(String username);

    List<User> getAllUser(Map<String, String> params);

    int countUsers();

    public boolean addOrUpdateUser(User u);

    public User getUserById(int id);
    public boolean deleteUser(int id);
    public User addUser(User u);
     public boolean authUser(String username, String password);
}
