import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DateTimeParser {

    private static final List<DateTimeFormatter> dateTimeFormatters = new ArrayList<>();
    private static final List<DateTimeFormatter> dateOnlyFormatters = new ArrayList<>();
    private static final Ui ui = new Ui();
    static {
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("d/M/yyyy HHmm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("dd.MM.yyyy HHmm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("d/M/yyyy HH:mm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));;
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("d/M/yyyy h:mm a"));
        dateTimeFormatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd h:mm a"));
        dateOnlyFormatters.add(DateTimeFormatter.ofPattern("d/M/yyyy"));
        dateOnlyFormatters.add(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dateOnlyFormatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        dateOnlyFormatters.add(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        dateOnlyFormatters.add(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        dateOnlyFormatters.add(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public DateTimeParser() {}
    public void searchTasks(String date, TaskManager taskManager) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        DateTimeFormatter fullDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter yearMonthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

        LocalDateTime fullDate = null;
        YearMonth yearMonth = null;
        Year year = null;
        boolean isFullDate = false;
        boolean isYearMonth = false;
        boolean isYear = false;

        try {
            fullDate = LocalDateTime.parse(date, fullDateFormatter);
            isFullDate = true;
        } catch (DateTimeParseException ignored) { }

        if (!isFullDate) {
            try {
                yearMonth = YearMonth.parse(date, yearMonthFormatter);
                isYearMonth = true;
            } catch (DateTimeParseException ignored) { }
        }

        if (!isFullDate && !isYearMonth) {
            try {
                year = Year.parse(date, yearFormatter);
                isYear = true;
            } catch (DateTimeParseException ignored) { }
        }

        taskManager.getLastTask().toString();
        for (Task task : taskManager.getTasks()) {

            if (task instanceof Deadline) {

                LocalDateTime taskDateTime = ((Deadline) task).getBy();
                compare_time(matchingTasks, fullDate, yearMonth, year,
                        isFullDate, isYearMonth, isYear, task, taskDateTime);
            } else if (task instanceof Event) {

                LocalDateTime taskStartDate = ((Event) task).getStart();
                compare_time(matchingTasks, fullDate, yearMonth, year,
                        isFullDate, isYearMonth, isYear, task, taskStartDate);
            }
        }

        if (!matchingTasks.isEmpty()) {
            ui.showTaskList(matchingTasks);
        } else {
            ui.showNoMatchingTasksMessage();
        }
    }

    private void compare_time(ArrayList<Task> matchingTasks, LocalDateTime fullDate,
                              YearMonth yearMonth, Year year, boolean isFullDate, boolean isYearMonth,
                              boolean isYear, Task task, LocalDateTime taskDateTime)
    {
        if (isFullDate && taskDateTime.toLocalDate().equals(fullDate.toLocalDate())) {

            matchingTasks.add(task);
        } else if (isYearMonth && YearMonth.from(taskDateTime).equals(yearMonth)) {

            matchingTasks.add(task);
        } else if (isYear && Year.from(taskDateTime).equals(year)) {

            matchingTasks.add(task);
        }
    }


    public static LocalDateTime parseDateTime(String dateTimeString) throws DateTimeParseException {
        for (DateTimeFormatter formatter : dateTimeFormatters) {
            try {
                return LocalDateTime.parse(dateTimeString, formatter);
            } catch (DateTimeParseException _) {
            }
        }
        for (DateTimeFormatter formatter : dateOnlyFormatters) {
            try {
                LocalDate date = LocalDate.parse(dateTimeString, formatter);
                return date.atTime(LocalTime.MAX);
            } catch (DateTimeParseException _) {
            }
        }
        throw new DateTimeParseException("Unable to parse date: " + dateTimeString, dateTimeString, 0);
    }
}
