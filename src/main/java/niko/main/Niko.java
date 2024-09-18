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
    private final Ui ui;

    /** The main window for interacting with the GUI. */
    private MainWindow mainWindow;

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
            // Optionally, display a load success message
        } catch (IOException e) {
            // Handle load failure
        }
    }

    /**
     * Sets the MainWindow instance for interaction between Niko and the GUI.
     *
     * @param mainWindow The MainWindow instance.
     */
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        // Display a welcome message
        String welcome = ui.showWelcomeMessage("Niko");
        mainWindow.showDialog(welcome);
    }

    /**
     * Processes the user input and provides a response.
     * This method is triggered by user input in the GUI.
     *
     * @param input The user's input command.
     */
    public void processUserInput(String input) {
        try {
            // Parse and execute the command
            Command command = Parser.parse(input);
            String response = command.execute(taskList, ui, storage);

            // Show Niko's response in the MainWindow
            mainWindow.showDialog(response);

            // Exit if the command is an exit command
            if (command.isExit()) {
                ui.showGoodbyeMessage();
                System.exit(0);
            }
        } catch (NikoException e) {
            // Handle any Niko-specific exceptions and show the error message
            String response = ui.showErrorMessage(e.getMessage());
            mainWindow.showError(response);
        } catch (Exception e) {
            // Handle any unforeseen exceptions
            String response = ui.showErrorMessage("An unexpected error occurred: " + e.getMessage());
            mainWindow.showError(response);
        }
    }


    /**
     * Retrieves the Ui instance.
     *
     * @return The Ui instance.
     */
    public Ui getUi() {
        return this.ui;
    }
}
