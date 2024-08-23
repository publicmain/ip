public class Task {
    protected String description;
    protected TaskStatus status;
    protected TaskType type;

    public Task(String description, TaskType type) {
        this.description = description;
        this.status = TaskStatus.NOT_DONE;  // 默认任务未完成
        this.type = type;
    }

    public String getStatusIcon() {
        return (status == TaskStatus.DONE ? "X" : " ");  // 根据状态返回图标
    }

    public void markAsDone() {
        this.status = TaskStatus.DONE;
    }

    public void unmarkAsDone() {
        this.status = TaskStatus.NOT_DONE;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
