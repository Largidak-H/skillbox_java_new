import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        Pattern patt = Pattern.compile("(?<number>\\d+)");
        Matcher match = patt.matcher(text);
        int sumOfEarnings = 0;
        while (match.find()) {
            sumOfEarnings += Integer.parseInt(match.group("number"));
        }
        System.out.println("Общий заработок составил: " + sumOfEarnings + " руб.");
    }
}