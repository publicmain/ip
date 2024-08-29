import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {

    public static String convertDate(String inputDate) {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH);


        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        LocalDate date = LocalDate.parse(inputDate, inputFormatter);


        return date.format(outputFormatter);
    }

    public static void main(String[] args) {

        String inputDate = "Dec 2 2019";


        String formattedDate = convertDate(inputDate);
        System.out.println(formattedDate);  // 输出: 2019-12-02
    }
}
