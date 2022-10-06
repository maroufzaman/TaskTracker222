package com.rmrfroot.tasktracker222.services;


import com.rmrfroot.tasktracker222.entities.deprecated.Task;

import java.util.List;

public interface TaskDaoService {

    public List<Task> findAll();
    public Task findById(int theId);

    public Task save(Task task);

    public void deleteById(int theId);

    public Task update( int id,Task task);

}
