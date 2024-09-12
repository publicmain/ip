package niko.main;

import niko.command.AddCommand;
import niko.command.Command;
import niko.command.DeleteCommand;
import niko.command.ExitCommand;
import niko.command.FindCommand;
import niko.command.ListCommand;
import niko.command.MarkCommand;
import niko.command.SearchCommand;
import niko.command.UnmarkCommand;
import niko.common.NikoException;
import niko.task.Deadline;
import niko.task.Event;
import niko.task.Todo;

/**
 * The Parser class is responsible for parsing user input and creating corresponding Command objects.
 */
public class Parser {
    /**
     * Parses the user's full command input and returns the corresponding Command object.
     *
     * @param fullCommand The full command input by the user.
     * @return The Command object corresponding to the user's input.
     * @throws NikoException If the command is not recognized.
     */
    public static Command parse(String fullCommand) throws NikoException {
        // Split command and handle empty input case
        String[] words = fullCommand.trim().split(" ", 2);
        if (words.length == 0 || words[0].isEmpty()) {
            throw new NikoException("Please enter a valid command.");
        }

        String commandWord = words[0];

        return switch (commandWord) {
            case "todo" -> {
                if (words.length < 2 || words[1].trim().isEmpty()) {
                    throw new NikoException("The description of a todo cannot be empty.");
                }
                yield new AddCommand(new Todo(words[1].trim()));
            }
            case "deadline" -> {
                try {
                    if (words.length < 2) {
                        throw new NikoException("Please provide both a task and a deadline.");
                    }
                    String[] parts = words[1].split(" /by ");
                    if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                        throw new NikoException("Please ensure the format is: 'deadline [task] /by [date]'.");
                    }
                    yield new AddCommand(new Deadline(parts[0].trim(), parts[1].trim()));
                } catch (Exception e) {
                    throw new NikoException("I'm sorry, please indicate both the task and the deadline.");
                }
            }
            case "event" -> {
                try {
                    if (words.length < 2) {
                        throw new NikoException("Please provide both event details and time.");
                    }
                    String[] eventParts = words[1].split(" /from | /to ");
                    if (eventParts.length < 3 || eventParts[0].trim().isEmpty() || eventParts[1].trim().isEmpty() || eventParts[2].trim().isEmpty()) {
                        throw new NikoException("Please ensure the format is: 'event [description] /from [start time] /to [end time]'.");
                    }
                    yield new AddCommand(new Event(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim()));
                } catch (Exception e) {
                    throw new NikoException("I'm sorry, please provide event description, start, and end times.");
                }
            }
            case "list" -> new ListCommand();
            case "bye" -> new ExitCommand();
            case "delete" -> {
                try {
                    if (words.length < 2) {
                        throw new NikoException("Please specify the task number to delete.");
                    }
                    int taskIndex = Integer.parseInt(words[1].trim());
                    yield new DeleteCommand(taskIndex);
                } catch (NumberFormatException e) {
                    throw new NikoException("Please provide a valid task number.");
                }
            }
            case "mark" -> {
                try {
                    if (words.length < 2) {
                        throw new NikoException("Please specify the task number to mark.");
                    }
                    int taskIndex = Integer.parseInt(words[1].trim());
                    yield new MarkCommand(taskIndex);
                } catch (NumberFormatException e) {
                    throw new NikoException("Please provide a valid task number.");
                }
            }
            case "unmark" -> {
                try {
                    if (words.length < 2) {
                        throw new NikoException("Please specify the task number to unmark.");
                    }
                    int taskIndex = Integer.parseInt(words[1].trim());
                    yield new UnmarkCommand(taskIndex);
                } catch (NumberFormatException e) {
                    throw new NikoException("Please provide a valid task number.");
                }
            }
            case "search" -> {
                if (words.length < 2 || words[1].trim().isEmpty()) {
                    throw new NikoException("Please provide a search query.");
                }
                yield new SearchCommand(words[1].trim());
            }
            case "find" -> {
                if (words.length < 2 || words[1].trim().isEmpty()) {
                    throw new NikoException("Please provide a search term to find.");
                }
                yield new FindCommand(words[1].trim());
            }
            default -> throw new NikoException("I'm sorry, but I don't know what that means :-(");
        };
    }
}
