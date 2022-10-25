package com.rmrfroot.tasktracker222.dao;

import com.rmrfroot.tasktracker222.entities.User;

public interface CustomUsersDAO {

    public Boolean hasUserData(String email);
    public User findUserByEmail(String email);
    public User findUsersById(int id);
    public void save(User user);
    public User findUserByUsername(String username);
}
