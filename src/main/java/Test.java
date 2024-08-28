import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Test {

    public static String convertDate(String inputDate) {
        // 定义解析器，解析类似 "Dec 2 2019" 的日期格式
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH);

        // 定义输出格式，将日期格式化为 "yyyy-MM-dd"
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 解析输入日期
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

        // 将解析后的日期格式化为输出格式
        return date.format(outputFormatter);
    }

    public static void main(String[] args) {
        // 示例输入
        String inputDate = "Dec 2 2019";

        // 转换并输出结果
        String formattedDate = convertDate(inputDate);
        System.out.println(formattedDate);  // 输出: 2019-12-02
    }
}
