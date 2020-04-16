import java.util.Scanner;
import java.util.regex.Pattern;
public class Loader {
    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите через пробел Ваши Фамилию, Имя и Отчество:");
        Scanner reader = new Scanner(System.in);
        String startString = reader.nextLine();
        if (!Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+$").
                matcher(startString).matches())
            System.out.println("Неверно введено Ф.И.О.");
        else {
            String[] fragments = startString.trim().split("\\s+");
            System.out.println("Фамилия: " + fragments[0] + "\nИмя: " + fragments[1] + "\nОтчество: " + fragments[2]);
        }
    }
}
