package Niko.Command;

import Niko.Common.NikoException;
import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.TaskList;

/**
 * Represents a command to mark a task as done in the task list.
 */
public class MarkCommand extends Command {
    private int index;

    /**
     * Constructs a MarkCommand with the specified task index.
     *
     * @param index The index of the task to be marked as done (1-based).
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Executes the mark command, marking the task at the specified index as done,
     * updating the UI, and saving the updated task list to storage.
     *
     * @param tasks   The task list to operate on.
     * @param ui      The UI to interact with the user.
     * @param storage The storage to save the updated task list.
     * @throws NikoException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        tasks.markTaskAsDone(index - 1);
        ui.showMarkTaskMessage(tasks.getTask(index - 1));
        String readyToWrite = tasks.getTasks().toString();
        storage.write(readyToWrite.substring(1, readyToWrite.length() - 1));
    }

    /**
     * Indicates that this command does not exit the application.
     *
     * @return {@code false}, as this command does not exit the application.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
