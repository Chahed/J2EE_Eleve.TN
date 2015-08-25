package com.chahed.spring.service;

import java.util.List;

import com.chahed.spring.model.Users;

public interface UserService {
    public void addUser(Users u);
    public void updateUser(Users u );
    public List<Users> listUser();
    public void removeUser(int id);

}
