/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.UserRepository;

/**
 *
 * @author ADMIN
 */
public class UserService {
    private UserRepository repos;

    public UserService() {
        repos = new UserRepository();
    }
    
    public Integer check(String username, String password){
        if (repos.getList(username, password) == null) {
            return -1;
        }
        return repos.getList(username, password).getRole();
    }
    
}
