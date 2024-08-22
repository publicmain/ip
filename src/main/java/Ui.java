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

    public void showAddTaskMessage(String task) {
        System.out.println("________________________________________");
        System.out.println("added: " + task);
        System.out.println("________________________________________");
    }

    public void showTaskList(String[] tasks) {
        System.out.println("________________________________________");
        for (int i = 0; i < tasks.length && tasks[i] != null; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
        System.out.println("________________________________________");
    }

    public void showGoodbyeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("________________________________________");
    }
}
