public class Niko {
    private String name;
    private Ui ui;
    private TaskManager taskManager;

    public Niko(String name) {
        this.name = name;
        this.ui = new Ui();
        this.taskManager = new TaskManager();
    }

    public void start() {
        ui.showWelcomeMessage(this.name);

        while (true) {
            String input = ui.getUserInput();

            if (input.equals("bye")) {
                break;
            }

            if (input.equals("list")) {
                ui.showTaskList(taskManager.getTasks());
            } else if (input.startsWith("mark")) {
                // 解析命令并标记任务为完成
                int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
                taskManager.markTaskAsDone(taskIndex);
                ui.showMarkTaskMessage(taskManager.getTask(taskIndex));
            } else if (input.startsWith("unmark")) {
                // 解析命令并标记任务为未完成
                int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
                taskManager.unmarkTaskAsDone(taskIndex);
                ui.showUnmarkTaskMessage(taskManager.getTask(taskIndex));
            } else {
                taskManager.addTask(input);
                ui.showAddTaskMessage(input);
            }
        }

        ui.showGoodbyeMessage();
    }
}
