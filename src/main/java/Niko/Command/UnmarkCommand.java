package Niko.Command;

import Niko.Common.NikoException;
import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.TaskList;

public class UnmarkCommand extends Command {
    private int INDEX;

    public UnmarkCommand(int index) {
        this.INDEX = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        tasks.unmarkTaskAsDone(INDEX - 1);
        ui.showUnmarkTaskMessage(tasks.getTask(INDEX - 1));
        String readyToWrite = tasks.getTasks().toString();
        storage.write(readyToWrite.substring(1, readyToWrite.length() - 1));
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
