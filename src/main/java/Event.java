import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Event extends Task {
    protected LocalDateTime start;
    protected LocalDateTime end;

    public Event(String description, String start, String end) {
        super(description, TaskType.EVENT);
        this.start = DateTimeParser.parseDateTime(start);  // 使用自定义解析器解析开始时间
        this.end = DateTimeParser.parseDateTime(end);  // 使用自定义解析器解析结束时间
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a", Locale.ENGLISH))
                + " to: " + end.format(DateTimeFormatter.ofPattern("MMM d yyyy h:mm a",Locale.ENGLISH)) + ")";
    }

    public LocalDateTime getStart()
    {
        return start;
    }
}
