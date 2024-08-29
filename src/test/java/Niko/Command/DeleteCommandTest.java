package Niko.Command;

import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.Task;
import Niko.Task.TaskList;
import Niko.Task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCommandTest {

    @Test
    void execute_deletesTaskAndUpdatesStorage() throws Exception {
        Task task = new Todo("Test Task");
        TaskList taskList = new TaskList();
        taskList.addTask(task);

        Ui ui = new Ui();
        Storage storage = new Storage("test_storage.txt");

        DeleteCommand deleteCommand = new DeleteCommand(1);
        deleteCommand.execute(taskList, ui, storage);

        assertEquals(0, taskList.getTaskCount());

    }
}
