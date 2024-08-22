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
            try {
                String input = ui.getUserInput();

                if (input.equals("bye")) {
                    break;
                }

                handleInput(input);

            } catch (DukeException e) {
                ui.showErrorMessage(e.getMessage());
            }
        }

        ui.showGoodbyeMessage();
    }

    private void handleInput(String input) throws DukeException {
        if (input.startsWith("todo")) {
            String description = input.substring(5).trim();
            if (description.isEmpty()) {
                throw new DukeException("The description of a todo cannot be empty.");
            }
            taskManager.addTask(new Todo(description));
            ui.showAddTaskMessage(taskManager.getLastTask(), taskManager.getTaskCount());

        } else if (input.startsWith("deadline")) {
            String[] parts = input.substring(9).split("/by ");
            if (parts.length < 2 || parts[0].trim().isEmpty()) {
                throw new DukeException("The description or deadline of a deadline cannot be empty.");
            }
            String description = parts[0].trim();
            String by = parts[1].trim();
            taskManager.addTask(new Deadline(description, by));
            ui.showAddTaskMessage(taskManager.getLastTask(), taskManager.getTaskCount());

        } else if (input.startsWith("event")) {
            String[] parts = input.substring(6).split("/from |/to ");
            if (parts.length < 3 || parts[0].trim().isEmpty()) {
                throw new DukeException("The description or date/time of an event cannot be empty.");
            }
            String description = parts[0].trim();
            String from = parts[1].trim();
            String to = parts[2].trim();
            taskManager.addTask(new Event(description, from, to));
            ui.showAddTaskMessage(taskManager.getLastTask(), taskManager.getTaskCount());

        } else if (input.equals("list")) {
            ui.showTaskList(taskManager.getTasks());

        } else if (input.startsWith("mark")) {
            int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            taskManager.markTaskAsDone(taskIndex);
            ui.showMarkTaskMessage(taskManager.getTask(taskIndex));

        } else if (input.startsWith("unmark")) {
            int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            taskManager.unmarkTaskAsDone(taskIndex);
            ui.showUnmarkTaskMessage(taskManager.getTask(taskIndex));

        } else if (input.startsWith("delete")) {
            int taskIndex = Integer.parseInt(input.split(" ")[1]) - 1;
            Task removedTask = taskManager.deleteTask(taskIndex);
            ui.showDeleteTaskMessage(removedTask, taskManager.getTaskCount());

        } else {
            throw new DukeException("I'm sorry, I don't know what that means.");
        }
    }
}
