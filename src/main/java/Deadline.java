import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Deadline extends Task {
    protected LocalDateTime by;
    public LocalDateTime getBy() {
        return by;
    }
    public Deadline(String description, String by) {
        super(description, TaskType.DEADLINE);
        this.by = DateTimeParser.parseDateTime(by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a", Locale.ENGLISH)) + ")";
    }
}
