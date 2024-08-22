public class Niko {
    private String name;
    private Ui ui;

    public Niko(String name) {
        this.name = name;
        this.ui = new Ui();
    }

    public void start() {
        // 打印问候语
        ui.showWelcomeMessage(this.name);

        // 循环回显用户输入
        while (true) {
            String input = ui.getUserInput();

            if (input.equals("bye")) {
                break;
            }

            // 回显用户的输入
            ui.showEcho(input);
        }

        // 打印告别语
        ui.showGoodbyeMessage();
    }
}
