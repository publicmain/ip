package niko.main;

import java.io.IOException;
import java.util.ArrayList;

import niko.command.Command;
import niko.common.NikoException;
import niko.task.Task;
import niko.task.TaskList;

/**
 * Represents the main Niko chatbot application.
 * It handles the initialization, execution of commands, and termination of the chatbot.
 */
public class Niko {

    /** The storage to read and write tasks. */
    private Storage storage;

    /** The list of tasks managed by the chatbot. */
    private final TaskList taskList;

    /** The UI to interact with the user. */
    private Ui ui;

    /**
     * Constructs a Niko chatbot with the specified file path for storage.
     *
     * @param filePath The file path where tasks are stored.
     */
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

    /**
     * Runs the chatbot, continuously accepting and executing user commands until the exit command is given.
     */
    public void run() {
        ui.showWelcomeMessage("niko");

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
