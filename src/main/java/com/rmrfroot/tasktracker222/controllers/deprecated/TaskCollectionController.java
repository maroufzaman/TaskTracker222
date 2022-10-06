package com.rmrfroot.tasktracker222.controllers.deprecated;

import com.rmrfroot.tasktracker222.entities.deprecated.Task;
import com.rmrfroot.tasktracker222.services.TaskDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("taskCollection")
public class TaskCollectionController {
    @Autowired
    private TaskDaoService taskDaoService;

    public TaskCollectionController(TaskDaoService taskDaoService){
        super();
        this.taskDaoService = taskDaoService;
    }

    @GetMapping
    public String main(Model model) {
        List<Task> taskList = taskDaoService.findAll();

        model.addAttribute("tasks", taskList);
        return "taskCollection";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable("id") int id) {
        return new ResponseEntity<>(taskDaoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        return new ResponseEntity<>(taskDaoService.save(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable("id") int id, @RequestBody Task task) {
        return new ResponseEntity<>(taskDaoService.save(task), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        taskDaoService.deleteById(id);
    }
}
