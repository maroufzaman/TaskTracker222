package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.entities.Users;

import java.util.ArrayList;
import java.util.List;

public interface UsersDaoService {

    public List<Users> findAll();

    public Users findById(int theId);

    public void save(Users users);

    public void deleteById(int theId);

    Users update(int id, Users day);

    public Boolean hasUserData(String email);
    public Users findUserByUsername(String username);

    public Users findUserByEmail(String email);
    public Users findUsersById(int id);
    public void registerUserToDatabase(String userName, String firstName, String lastName, String militaryEmail, String civilianEmail,
                                       String email,String phoneNumber, String officeNumber, String rank, String workCenter,
                                       String flight, ArrayList<String> teams);
}
