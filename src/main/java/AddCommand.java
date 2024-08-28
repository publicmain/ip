public class AddCommand extends Command {
    private Task task;
    private  String readyToWrite;
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        tasks.addTask(task);
        ui.showAddTaskMessage(task, tasks.getTaskCount());
        readyToWrite = tasks.getTasks().toString();
        storage.write(readyToWrite.substring(1, readyToWrite.length() - 1));

    }
}
