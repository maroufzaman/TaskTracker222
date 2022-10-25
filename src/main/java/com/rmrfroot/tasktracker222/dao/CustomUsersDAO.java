package com.rmrfroot.tasktracker222.dao;

import com.rmrfroot.tasktracker222.entities.DrillSchedules;
import com.rmrfroot.tasktracker222.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUsersDAO {

    public Boolean hasUserData(String email);
    public Users findUserByEmail(String email);
    public Users findUsersById(int id);
    public void save(Users users);
}
