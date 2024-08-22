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

    public void showEcho(String message) {
        System.out.println("________________________________________");
        System.out.println(message);
        System.out.println("________________________________________");
    }

    public void showGoodbyeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("________________________________________");
    }
}
