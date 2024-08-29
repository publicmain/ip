package Niko.Task;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Returns the list of tasks.
     *
     * @return The list of tasks as an ArrayList.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the task at the specified index.
     *
     * @param index The index of the task to retrieve.
     * @return The task at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        } else {
            throw new IndexOutOfBoundsException("Task index is out of bounds.");
        }
    }

    /**
     * Returns the last task in the list.
     *
     * @return The last task in the list.
     */
    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to mark as done.
     */
    public void markTaskAsDone(int index) {
        Task task = getTask(index);
        task.markAsDone();
    }

    /**
     * Sets the date for the last task in the list.
     *
     * @param date The date to set.
     */
    public void setDate(Date date) {
        Task task = getLastTask();
        task.setDate(date);
    }

    /**
     * Returns the date of the last task in the list.
     *
     * @return The date of the last task as a Date object.
     */
    public Date getDate() {
        Task task = getLastTask();
        return task.getDate();
    }

    /**
     * Marks the task at the specified index as not done.
     *
     * @param index The index of the task to unmark as done.
     */
    public void unmarkTaskAsDone(int index) {
        Task task = getTask(index);
        task.unmarkAsDone();
    }

    /**
     * Deletes the task at the specified index from the list.
     *
     * @param index The index of the task to delete.
     * @return The deleted task.
     */
    public Task deleteTask(int index) {
        Task task = getTask(index);
        tasks.remove(index);
        return task;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The number of tasks in the list.
     */
    public int getTaskCount() {
        return tasks.size();
    }
}
