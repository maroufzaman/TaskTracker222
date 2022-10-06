package com.rmrfroot.tasktracker222.entities.deprecated;

import java.util.ArrayList;
import java.util.List;

public class TaskCollection {
    private List<Task> taskCollection;

    public TaskCollection() {
        taskCollection = new ArrayList<>();
    }

    public void add(Task task) {
        taskCollection.add(task);
    }

    public int isEmpty() {
        if(taskCollection.size() == 0)
            return 0;
        return 1;
    }

    public int getSize() {
        return taskCollection.size();
    }
    
    
    //remove the Task object
    public void removeTask(Task task) {
      if (containsTask(task)){
          int  i = taskCollection.indexOf(task);

          taskCollection.remove(i);
      }
    }
    
    
    //check whether the given task object is in the taskCollection
    public boolean containsTask(Task task) {
        return taskCollection.contains(task);
    }

    //get the Task object
//    public Task getTask() {
//        return taskCollection.get(index);
//    }
    
    
    
    
    
}
