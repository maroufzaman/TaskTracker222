package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.DAO.DaysDAO;
import com.rmrfroot.tasktracker222.entities.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Function for the days of the drills
 * @author Visoth
 * @author Tobechi
 */
@Service
public class DaoServiceImpl implements DaoService {

    @Autowired
    private DaysDAO daysDAO;

    /**
     * Find all days of the drills
     * @author Visoth
     * @return all the days
     */
    @Override
    public List<Day> findAll() {
        return daysDAO.findAll();
    }

    /**
     * Finds accounts by their ID
     * @author Visoth
     * @param theId finds the days according to their ID
     * @return account that matched the id
     * @throws RuntimeException if it the id doesn't match the account
     */
    @Override
    public Day findById(int theId) {
        Optional<Day> result = daysDAO.findById(theId);
        Day acc=null;
        if(result.isPresent()) {
            acc=result.get();
        }
        else {
            //we didn't find the employee
            throw new RuntimeException("Did not find account id - "+theId);
        }
        return acc;
    }

    /**
     * Saves the day
     * @param day saves the day
     * @return day that was saved
     * @author Visoth
     */
    @Override
    public Day save(Day day) {
        daysDAO.save(day);
        return day;
    }

    /**
     * Delete according to the ID
     * @param theId matched the id with the day to delete
     * @author Visoth
     */
    @Override
    public void deleteById(int theId) {
        daysDAO.deleteById(theId);
    }

    /**
     * Update the day according to the ID
     * @author Tobechi
     * @param id use id to pinpoint the right Day
     * @param day change the existing day with this day
     * @return updated day
     * @throws RuntimeException Day did not match the ID
     */
    @Override
    public Day update(int id, Day day) {
        Optional<Day> result = daysDAO.findById(id);
        Day updatedDay = null;
        if(result.isPresent()) {
            updatedDay = result.get();
            daysDAO.deleteById(id);
        }
        else {
            //day not found
            throw new RuntimeException("Did not find day id - " + id);
        }
        updatedDay.setId(day.getId());
        updatedDay.setFirstName(day.getFirstName());
        updatedDay.setLastName(day.getLastName());
        updatedDay.setPassword(day.getPassword());
        updatedDay.setEmail(day.getEmail());
        daysDAO.save(updatedDay);
        return updatedDay;
    }
}
