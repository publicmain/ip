import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        } else {
            throw new IndexOutOfBoundsException("Task index is out of bounds.");
        }
    }

    public Task getLastTask() {
        return tasks.getLast();
    }

    public void markTaskAsDone(int index) {
        Task task = getTask(index);
        task.markAsDone();
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
