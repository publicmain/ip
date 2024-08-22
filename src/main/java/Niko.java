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
                int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
                taskManager.markTaskAsDone(taskIndex);
                ui.showMarkTaskMessage(taskManager.getTask(taskIndex));
            } else if (input.startsWith("unmark")) {
                int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
                taskManager.unmarkTaskAsDone(taskIndex);
                ui.showUnmarkTaskMessage(taskManager.getTask(taskIndex));
            } else if (input.startsWith("todo")) {
                String description = input.substring(5);
                taskManager.addTask(new Todo(description));
                ui.showAddTaskMessage(taskManager.getLastTask(), taskManager.getTaskCount());
            } else if (input.startsWith("deadline")) {
                String[] parts = input.substring(9).split("/by ");
                String description = parts[0].trim();
                String by = parts[1].trim();
                taskManager.addTask(new Deadline(description, by));
                ui.showAddTaskMessage(taskManager.getLastTask(), taskManager.getTaskCount());
            } else if (input.startsWith("event")) {
                String[] parts = input.substring(6).split("/from |/to ");
                String description = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                taskManager.addTask(new Event(description, from, to));
                ui.showAddTaskMessage(taskManager.getLastTask(), taskManager.getTaskCount());
            }
        }

        ui.showGoodbyeMessage();
    }
}
