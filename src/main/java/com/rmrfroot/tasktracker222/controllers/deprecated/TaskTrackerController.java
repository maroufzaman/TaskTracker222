package com.rmrfroot.tasktracker222.controllers.deprecated;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskTrackerController {

    //get task collection singleton

    @GetMapping("/task-tracker-recipient")
    public String taskTrackerRecipient(Model model){
        return "TaskTracker";
    }
}
