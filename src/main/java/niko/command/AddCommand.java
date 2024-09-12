//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package niko.command;

import niko.common.NikoException;
import niko.main.Storage;
import niko.main.Ui;
import niko.task.Task;
import niko.task.TaskList;

/**
 * Represents a command to add a task to the task list.
 * This command will add the specified task, update the UI with the added task,
 * and then write the updated task list to the storage.
 */
public class AddCommand extends Command {

    /** The task to be added to the task list. */
    private Task task;

    /** A string representation of the tasks to be written to storage. */
    private String readyToWrite;

    /**
     * Constructs an AddCommand with the specified task.
     *
     * @param task The task to be added to the task list.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Executes the add command, which adds the task to the task list,
     * updates the UI with the new task, and writes the updated task list to storage.
     *
     * @param tasks   The task list to which the task will be added.
     * @param ui      The UI to be updated with the new task.
     * @param storage The storage where the updated task list will be written.
     * @return
     * @throws NikoException If there is an error during the writing process to the storage.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        assert tasks != null : "TaskList cannot be null in execute";
        assert ui != null : "UI cannot be null in execute";
        assert storage != null : "Storage cannot be null in execute";

        tasks.addTask(this.task);

        // Assert that the task was added successfully
        assert tasks.getTasks().contains(this.task) : "Task was not added to the task list";

        this.readyToWrite = tasks.getTasks().toString();

        // Ensure that readyToWrite is a valid string before writing to storage
        assert readyToWrite.length() > 2 : "readyToWrite must contain valid task data";

        storage.write(this.readyToWrite.substring(1, this.readyToWrite.length() - 1));

        // Ensure that the write was successful (you may want to verify in Storage class)
        return ui.showAddTaskMessage(this.task, tasks.getTaskCount());
    }
}
