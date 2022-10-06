package com.rmrfroot.tasktracker222.services;

import com.rmrfroot.tasktracker222.dao.deprecated.TaskDao;
import com.rmrfroot.tasktracker222.entities.deprecated.Task;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskDaoImpl implements TaskDaoService{

    private TaskDao taskDao;

    public TaskDaoImpl(@Lazy TaskDao taskDao){
        super();
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> findAll() {
        return taskDao.findAll();
    }

    @Override
    public Task findById(int theId) {
        Optional<Task> result = taskDao.findById(theId);
        Task t = null;
        if(result.isPresent()) {
            t = result.get();
        }
        else {
            //task not found
            throw new RuntimeException("Did not find task id - " + theId);
        }
        return t;
    }

    @Override
    public Task save(Task task) {
        return taskDao.save(task);
    }

    @Override
    public void deleteById(int theId) {
        taskDao.findById(theId);
        Optional<Task> result = taskDao.findById(theId);
        Task t = null;
        if(result.isPresent()) {
            t = result.get();
            taskDao.deleteById(theId);
        }
        else {
            //task not found
            throw new RuntimeException("Did not find task id - " + theId);
        }

    }

    @Override
    public Task update(int id, Task task) {
        Optional<Task> result = taskDao.findById(id);
        Task updatedTask = null;

        if (result.isPresent()) {
            updatedTask = result.get();
        } else {
            //task not found
            throw new RuntimeException("Did not find task id - " + id);
        }

        updatedTask.setTitle(task.getTitle());
        updatedTask.setTask_priority(task.getTask_priority());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setPdf_file(task.getPdf_file());
        updatedTask.setStartDate(task.getStartDate());
        updatedTask.setDeadlineDate(task.getDeadlineDate());
        updatedTask.setNote(task.getNote());
        taskDao.save(updatedTask);
        return updatedTask;
    }
}
