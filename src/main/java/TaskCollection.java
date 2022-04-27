
import java.util.*;
public class TaskCollection {

    //declare variables
    private List<Task> taskCollection = new ArrayList<Task>();
    private int priority;
    private int index;

    //constructor
    public TaskCollection() {
            index = 0;
    }

    //add a Task object to the collection
    public void addTask(Task task) {
        taskCollection.add(task);
          index++;
    }

    //remove the Task object
    public void removeTask(Task task) {
      int  i = taskCollection.indexOf(task);
        taskCollection.remove(i);
    }

    //set the priority of the task object
    public void setPriority() {

        Scanner input = new Scanner(System.in);
        System.out.println("Number 1 will represent higher priority and Number 2 will represent lower priority");
        System.out.println("Enter 1 or 2 to determine the priority of the task");
        priority = input.nextInt();
    }

    //get Priority
    public int getPriority() {
        return priority;
    }

    //get the number of Task object
    public int size() {
        return taskCollection.size();
    }

    //clear all Task object
    public void clearAll() {
        taskCollection.clear();
    }

    //check whether there is a  task object
    public boolean containsTask(Task task) {
        return taskCollection.contains(task);
    }

    //get the Task object
    public Task getTask() {
        return taskCollection.get(index);
    }

    //Check whether the TaskCollection is empty
    public boolean isEmpty() {
        return taskCollection.isEmpty();
    }




}
