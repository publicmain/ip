public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager() {
        this.tasks = new Task[100];  // 限制最多 100 个任务
        this.taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < 100) {
            tasks[taskCount] = task;
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

    public int getTaskCount() {
        return taskCount;
    }

    public Task getLastTask() {
        return tasks[taskCount - 1];
    }
}
