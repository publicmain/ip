package Niko.Command;

import Niko.Main.Storage;
import Niko.Main.Ui;
import Niko.Task.TaskList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {

    @Test
    void execute_showsGoodbyeMessage() {
        Ui ui = new Ui();
        Storage storage = new Storage("test_storage.txt");
        TaskList taskList = new TaskList();

        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute(taskList, ui, storage);


    }

    @Test
    void isExit_returnsTrue() {
        ExitCommand exitCommand = new ExitCommand();
        assertTrue(exitCommand.isExit());
    }
}
