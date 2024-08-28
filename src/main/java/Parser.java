public class Parser {
    public static Command parse(String fullCommand) throws NikoException {
        String[] words = fullCommand.split(" ", 2);
        String commandWord = words[0];

        switch (commandWord) {
            case "todo":
                return new AddCommand(new Todo(words[1]));
            case "deadline":
                String[] parts = words[1].split(" /by ");
                return new AddCommand(new Deadline(parts[0], parts[1]));
            case "event":
                String[] eventParts = words[1].split(" /from | /to ");
                return new AddCommand(new Event(eventParts[0], eventParts[1], eventParts[2]));
            case "list":
                return new ListCommand();
            case "bye":
                return new ExitCommand();
            case "delete":
                return new DeleteCommand(Integer.parseInt(words[1]));
            case "mark":
                return new MarkCommand(Integer.parseInt(words[1]));
            case "unmark":
                return new UnmarkCommand(Integer.parseInt(words[1]));
            case "search":
                return new SearchCommand(words[1]);
            default:
                throw new NikoException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
