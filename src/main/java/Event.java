import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Event extends Task {
    protected LocalDateTime start;
    protected LocalDateTime end;

    public Event(String description, String start, String end) {
        super(description, TaskType.EVENT);
        try {
            this.start = DateTimeParser.convertDate(start);
            this.end = DateTimeParser.convertDate(end);
        }catch (DateTimeParseException ignore) {}
        try {
            this.start = DateTimeParser.parseDateTime(start);
            this.end = DateTimeParser.parseDateTime(end);
        }catch (DateTimeParseException ignore) {}

    }

    @Override
    public String toString(){

        return "[E]" + super.toString() + " (from: " + start.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a", Locale.ENGLISH))
                + " to: " + end.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a",Locale.ENGLISH)) + ")";
    }

    public LocalDateTime getStart()
    {
        return start;
    }
}
