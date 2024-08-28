package Niko.Main;

import Niko.Command.Command;
import Niko.Common.NikoException;
import Niko.Task.Task;
import Niko.Task.TaskList;

import java.io.IOException;
import java.util.ArrayList;

public class Niko {

    private Storage storage;
    private final TaskList taskList;
    private Ui ui;

    public Niko(String filePath) {
        this.taskList = new TaskList();
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            ArrayList<Task> tasks = storage.load();
            for (Task task : tasks) {
                taskList.addTask(task);
            }
            ui.showLoadSuccessMessage(tasks.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        ui.showWelcomeMessage("Niko");

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.getUserInput();
                Command command = Parser.parse(fullCommand);
                command.execute(taskList, ui, storage);
                isExit = command.isExit();
            } catch (NikoException e) {
                ui.showErrorMessage(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
        ui.showGoodbyeMessage();
    }

}
