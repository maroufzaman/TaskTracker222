package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.dao.UsersDao;
import com.rmrfroot.tasktracker222.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsersDaoServiceImpl implements UsersDaoService {
    @Autowired
    private UsersDao usersDAO;


    @Override
    public List<Users> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = usersDAO.findById(theId);

        Users acc;
        
        if(result.isPresent()) {
            acc=result.get();
        }
        else {
            //we didn't find the employee
            throw new RuntimeException("Did not find account id - "+theId);
        }
        return acc;
    }

    @Override
    public Users save(Users day) {
        usersDAO.save(day);
        return day;
    }

    @Override
    public void deleteById(int theId) {
        usersDAO.deleteById(theId);
    }

    @Override
    public Users update(int id, Users user) {
        Optional<Users> result = usersDAO.findById(id);

        Users updatedUser;

        if (result.isPresent()) {
            updatedUser = result.get();
            usersDAO.deleteById(id);
        } else {
            //day not found
            throw new RuntimeException("Did not find day id - " + id);
        }
        updatedUser.setId(user.getId());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirst_name(user.getFirst_name());
        updatedUser.setLast_name(user.getLast_name());
        updatedUser.setRegister_date(user.getRegister_date());
        updatedUser.setUpdate_date(user.getUpdate_date());
        usersDAO.save(updatedUser);
        return updatedUser;
    }

}