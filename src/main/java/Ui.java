import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage(String name) {
        System.out.println("________________________________________");
        System.out.println("Hello! I'm " + name);
        System.out.println("What can I do for you?");
        System.out.println("________________________________________");
    }

    public String getUserInput() {
        return scanner.nextLine();
    }
    public void showLoadSuccessMessage(int taskCount) {
        System.out.println("Successfully loaded " + taskCount + " tasks from file.");
    }

    public void showAddTaskMessage(Task task, int taskCount) {
        System.out.println("________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        System.out.println("________________________________________");
    }

    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println("________________________________________");
        if(!tasks.isEmpty()){
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + "." + tasks.get(i));
            }
        }else{
            System.out.println("You task is empty");
        }

        System.out.println("________________________________________");
    }

    public void showMarkTaskMessage(Task task) {
        System.out.println("________________________________________");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
        System.out.println("________________________________________");
    }

    public void showUnmarkTaskMessage(Task task) {
        System.out.println("________________________________________");
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + task);
        System.out.println("________________________________________");
    }

    public void showDeleteTaskMessage(Task task, int taskCount) {
        System.out.println("________________________________________");
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        System.out.println("________________________________________");
    }

    public void showErrorMessage(String message) {
        System.out.println("________________________________________");
        System.out.println("OOPS!!! " + message);
        System.out.println("________________________________________");
    }

    public void showGoodbyeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("________________________________________");
    }

    public void showNoMatchingTasksMessage() {
        System.out.println("________________________________________");
        System.out.println("OOPS!!! " + "No matching tasks found!");
        System.out.println("________________________________________");
    }

    public void showLine() {
        System.out.println("________________________________________");
    }
}
