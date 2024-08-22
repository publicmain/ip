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

    public void showAddTaskMessage(Task task, int taskCount) {
        System.out.println("________________________________________");
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + taskCount + " tasks in the list.");
        System.out.println("________________________________________");
    }

    public void showTaskList(Task[] tasks) {
        System.out.println("________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.length && tasks[i] != null; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
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

    public void showGoodbyeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("________________________________________");
    }
}
