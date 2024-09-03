package niko.main;

import java.util.ArrayList;
import java.util.Scanner;

import niko.task.Task;

/**
 * Handles interactions with the user.
 */
public class Ui {

    /** Scanner for reading user input from the console. */
    private Scanner scanner;

    /**
     * Constructs a Ui object to interact with the user.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message to the user.
     *
     * @param name The name of the chatbot.
     */
    public void showWelcomeMessage(String name) {
        System.out.println("________________________________________");
        System.out.println("Hello! I'm " + name);
        System.out.println("What can I do for you?");
        System.out.println("________________________________________");
    }

    /**
     * Reads the user input from the console.
     *
     * @return The user input as a string.
     */
    public String getUserInput() {
        return scanner.nextLine();
    }

    /**
     * Displays a message indicating that tasks were successfully loaded.
     *
     * @param taskCount The number of tasks loaded.
     */
    public void showLoadSuccessMessage(int taskCount) {
        System.out.println("Successfully loaded " + taskCount + " tasks from file.");
    }

    /**
     * Displays a message indicating that a task was successfully added.
     *
     * @param task      The task that was added.
     * @param taskCount The total number of tasks in the list.
     */
    public void showAddTaskMessage(Task task, int taskCount) {
        System.out.println("________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        System.out.println("________________________________________");
    }

    /**
     * Displays the list of tasks to the user.
     *
     * @param tasks The list of tasks to display.
     */
    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println("________________________________________");
        if (!tasks.isEmpty()) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + "." + tasks.get(i));
            }
        } else {
            System.out.println("Your task list is empty.");
        }
        System.out.println("________________________________________");
    }

    /**
     * Displays a message indicating that a task was marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void showMarkTaskMessage(Task task) {
        System.out.println("________________________________________");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        System.out.println("________________________________________");
    }

    /**
     * Displays a message indicating that a task was unmarked as done.
     *
     * @param task The task that was unmarked as done.
     */
    public void showUnmarkTaskMessage(Task task) {
        System.out.println("________________________________________");
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
        System.out.println("________________________________________");
    }

    /**
     * Displays a message indicating that a task was deleted.
     *
     * @param task      The task that was deleted.
     * @param taskCount The total number of tasks remaining in the list.
     */
    public void showDeleteTaskMessage(Task task, int taskCount) {
        System.out.println("________________________________________");
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        System.out.println("________________________________________");
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void showErrorMessage(String message) {
        System.out.println("________________________________________");
        System.out.println("OOPS!!! " + message);
        System.out.println("________________________________________");
    }

    /**
     * Displays the goodbye message to the user.
     */
    public void showGoodbyeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("________________________________________");
    }

    /**
     * Displays a message indicating that no matching tasks were found.
     */
    public void showNoMatchingTasksMessage() {
        System.out.println("________________________________________");
        System.out.println("OOPS!!! No matching tasks found!");
        System.out.println("________________________________________");
    }

    /**
     * Displays a line separator for better readability.
     */
    public void showLine() {
        System.out.println("________________________________________");
    }
}
