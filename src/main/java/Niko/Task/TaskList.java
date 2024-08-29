package Niko.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Task> findTasks(String description) {
        ArrayList<Task> findTasks = new ArrayList<>();
        for (Task task : tasks) {
            String info = task.getDescription();
            String[] parts = info.split(" ");
            if ((parts.length > 0 && parts[0].equals(description)) ||
                    (parts.length > 1 && parts[1].equals(description))) {
                System.out.println("Match found: " + task);
                findTasks.add(task);
            }
        }
        System.out.println("Search complete. Number of matching tasks found: " + findTasks.size());
        return findTasks;
    }

    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        } else {
            throw new IndexOutOfBoundsException("index is out of bounds.");
        }
    }

    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    public void markTaskAsDone(int index) {
        Task task = getTask(index);
        task.markAsDone();
    }
    public void setDate(Date date){
        Task task = getLastTask();
        task.setDate(date);
    }
    public Date getDate(){
        Task task = getLastTask();
        return task.getDate();
    }
    public void unmarkTaskAsDone(int index) {
        Task task = getTask(index);
        task.unmarkAsDone();
    }

    public Task deleteTask(int index) {
        Task task = getTask(index);
        tasks.remove(index);
        return task;
    }

    public int getTaskCount() {
        return tasks.size();
    }
}
