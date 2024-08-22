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
        // 打印问候语
        ui.showWelcomeMessage(this.name);

        // 循环处理用户输入
        while (true) {
            String input = ui.getUserInput();

            if (input.equals("bye")) {
                break;
            }

            // 处理不同的命令
            if (input.equals("list")) {
                // 显示任务列表
                ui.showTaskList(taskManager.getTasks());
            } else {
                // 添加任务并显示添加信息
                taskManager.addTask(input);
                ui.showAddTaskMessage(input);
            }
        }

        // 打印告别语
        ui.showGoodbyeMessage();
    }
}
