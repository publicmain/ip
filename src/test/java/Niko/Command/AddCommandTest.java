package Niko.Command;

import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.Task;
import Niko.Task.TaskList;
import Niko.Task.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    @Test
    void execute_addsTaskAndUpdatesStorage() throws Exception {
        TaskList taskList = new TaskList();
        Ui ui = new Ui();
        Storage storage = new Storage("test_storage.txt");

        Task task = new Todo("Test Task");
        AddCommand addCommand = new AddCommand(task);
        addCommand.execute(taskList, ui, storage);

        assertEquals(1, taskList.getTaskCount());
        assertEquals(task, taskList.getTasks().get(0));


    }
}
