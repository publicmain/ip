package Niko.Command;

import Niko.Common.NikoException;
import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.Task;
import Niko.Task.TaskList;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String description;

    public FindCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        try {
            ArrayList<Task> taskList = tasks.findTasks(this.description);

            if (taskList == null || taskList.isEmpty()) {
                ui.showNoMatchingTasksMessage();
            } else {
                ui.showTaskList(taskList);
            }

        } catch (Exception e) {

            ui.showErrorMessage("An error occurred while finding tasks: " + e.getMessage());
        }
    }
}
