public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager() {
        this.tasks = new Task[100];  // 限制最多 100 个任务
        this.taskCount = 0;
    }

    public void addTask(String description) {
        if (taskCount < 100) {
            tasks[taskCount] = new Task(description);
            taskCount++;
        }
    }

    public Task[] getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks[index];
    }

    public void markTaskAsDone(int index) {
        if (index < taskCount) {
            tasks[index].markAsDone();
        }
    }

    public void unmarkTaskAsDone(int index) {
        if (index < taskCount) {
            tasks[index].unmarkAsDone();
        }
    }
}
