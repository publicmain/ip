public class TaskManager {
    private String[] tasks;
    private int taskCount;

    public TaskManager() {
        this.tasks = new String[100];  // 限制最多 100 个任务
        this.taskCount = 0;
    }

    public void addTask(String task) {
        if (taskCount < 100) {
            tasks[taskCount] = task;
            taskCount++;
        }
    }

    public String[] getTasks() {
        return tasks;
    }
}
