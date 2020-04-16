import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Loader {
    public static void main(String[] args) {
        Calendar calendarOld = Calendar.getInstance();
        calendarOld.set(1989, Calendar.DECEMBER, 6);
        Calendar calendarNow = Calendar.getInstance();
        int age = 0;
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);
        for (int i = calendarOld.get(Calendar.YEAR); i <= calendarNow.get(Calendar.YEAR); i++) {
            if (calendarOld.getTime().getTime() < calendarNow.getTime().getTime()) {
                Date date = calendarOld.getTime();
                System.out.println(age + " - " + dateFormat.format(date));
                calendarOld.add(Calendar.YEAR, 1);
                age++;
            }
        }
    }
}
