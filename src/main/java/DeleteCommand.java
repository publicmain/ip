public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        Task removedTask = tasks.deleteTask(index - 1);
        ui.showDeleteTaskMessage(removedTask, tasks.getTaskCount());
        String readyToWrite = tasks.getTasks().toString();
        storage.write(readyToWrite.substring(1, readyToWrite.length() - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
