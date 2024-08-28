public class SearchCommand extends Command {
    private String query;

    public SearchCommand(String query) {
        this.query = query;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NikoException {
        DateTimeParser parser = new DateTimeParser();
        parser.searchTasks(query, tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
