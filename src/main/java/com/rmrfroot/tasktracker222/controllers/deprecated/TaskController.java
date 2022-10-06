package com.rmrfroot.tasktracker222.controllers.deprecated;

import com.rmrfroot.tasktracker222.entities.deprecated.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class TaskController {

    @GetMapping("task-tracker-user")
    public String taskTrackerUser(Model model){

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date startDate = simpleDateFormat.parse("2022-05-20");
            Date deadline = simpleDateFormat.parse("2022-05-25");
            Task sampleTask = new Task(01, "Sample Task 1", "High", "This is a sample task description.", null, startDate, deadline, "Sample note");

            Date startDate2 = simpleDateFormat.parse("2022-06-12");
            Date deadline2 = simpleDateFormat.parse("2022-06-18");
            Task sampleTask2 = new Task(02, "Sample Task 2", "Medium", "This is another sample task description!", null, startDate2, deadline2, "Another sample note");

            ArrayList<Task> tasks = new ArrayList<>();

            tasks.add(sampleTask);
            tasks.add(sampleTask2);

            model.addAttribute("tasks", tasks);

        } catch (Exception e){
            e.printStackTrace();
        }
        return "TaskTracker";
    }

}
