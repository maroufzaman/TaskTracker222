package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.entities.Users;

import java.util.List;

public interface UserService {

    public List<Users> findAll();

    public Users findById(int theId);

    public Users save(Users day);

    public void deleteById(int theId);

    Users update(int id, Users day);
}