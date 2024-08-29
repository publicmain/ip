package Niko.Task;

import java.util.Date;

public class Task {
    protected String description;
    protected TaskStatus status;
    protected TaskType type;
    protected Date date;

    public Task(String description, TaskType type) {
        this.description = description;
        this.status = TaskStatus.NOT_DONE;
        this.type = type;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
    public String getStatusIcon() {
        return (status == TaskStatus.DONE ? "X" : " ");
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
