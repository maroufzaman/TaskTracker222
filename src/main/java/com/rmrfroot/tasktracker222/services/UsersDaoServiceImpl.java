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

        if (result.isPresent()) {
            acc = result.get();
        } else {
            //we didn't find the employee
            throw new RuntimeException("Did not find account id - " + theId);
        }
        return acc;
    }

    @Override
    public Users save(Users user) {
        usersDAO.save(user);
        return user;
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
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setMilitaryEmail(user.getMilitaryEmail());
        updatedUser.setCivilianEmail(user.getCivilianEmail());
        updatedUser.setPhoneNumber(user.getPhoneNumber());
        updatedUser.setOfficeNumber(user.getOfficeNumber());
        updatedUser.setRank(user.getRank());
        updatedUser.setWorkCenter(user.getWorkCenter());
        updatedUser.setFlight(user.getFlight());
        updatedUser.setTeams(user.getTeams());
        usersDAO.save(updatedUser);
        return updatedUser;
    }

}