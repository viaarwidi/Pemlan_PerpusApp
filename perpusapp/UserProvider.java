/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpusapp;

/**
 *
 * @author user
 */
public class UserProvider {
    User[] users;
    

    UserProvider() {
        // Inisialisasi pengguna
        users = new User[1];
        users[0] = new User("User 1", "user1@gmail.com", "PasswordUser1");
    }
    
     public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
     
     public User[] getUser(){
         return users;
     }
}