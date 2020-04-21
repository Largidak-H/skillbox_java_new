import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Loader {
    public static void main(String[] args) {
        LocalDate dateBirthday = LocalDate.of(1989, Month.DECEMBER, 6);
        LocalDate dateNow = LocalDate.now();
        int age = 0;
        for (int i = dateBirthday.getYear(); i <= dateNow.getYear(); i++) {
            if (dateBirthday.isBefore(dateNow)) {
                System.out.println(age + " - " + dateBirthday.format(DateTimeFormatter.ofPattern
                        ("dd.MM.yyyy - E", Locale.ENGLISH)));
                dateBirthday = dateBirthday.plusYears(1);
                age++;
            }
        }
    }
}
