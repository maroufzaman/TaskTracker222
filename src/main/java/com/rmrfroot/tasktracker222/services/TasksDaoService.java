package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.entities.deprecated.Task;

import java.util.List;

public interface TasksDaoService {
    public List<Task> findAll();

    public Task findById(int theId);

    public void save(Task task);

    public void deleteById(int theId);
}
