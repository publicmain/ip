public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        tasks.unmarkTaskAsDone(index - 1);
        ui.showUnmarkTaskMessage(tasks.getTask(index - 1));
        String readyToWrite = tasks.getTasks().toString();
        storage.write(readyToWrite.substring(1, readyToWrite.length() - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
