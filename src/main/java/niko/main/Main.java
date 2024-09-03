package niko.main;

/**
 * The Main class to start the Niko chatbot.
 */
public class Main {
    /**
     * The main method to start the Niko chatbot.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Niko chatbot = new Niko("example.txt");
        chatbot.run();
    }
}
