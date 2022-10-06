package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.dao.deprecated.TasksDAO;
import com.rmrfroot.tasktracker222.entities.deprecated.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TasksDaoServiceImpl implements TasksDaoService{

    @Autowired
    private TasksDAO tasksDAO;

    @Override
    public List<Task> findAll() {
        return tasksDAO.findAll();
    }

    @Override
    public Task findById(int theId) {
        Optional<Task> result = tasksDAO.findById(theId);
        Task task=null;
        if(result.isPresent()) {
            task=result.get();
        }
        else {
            //we didn't find the employee
            throw new RuntimeException("Did not find task id - "+theId);
        }
        return task;
    }

    @Override
    public void save(Task task) {
        tasksDAO.save(task);
    }

    @Override
    public void deleteById(int theId) {
        tasksDAO.deleteById(theId);

    }
}
