package Niko.Command;

import Niko.Common.NikoException;
import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.TaskList;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command, displaying all tasks in the task list to the user.
     *
     * @param tasks   The task list to display.
     * @param ui      The UI to display the task list.
     * @param storage The storage (not used in this command).
     * @throws NikoException If an error occurs during execution.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        ui.showTaskList(tasks.getTasks());
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
