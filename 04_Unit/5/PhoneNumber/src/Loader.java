import java.util.Scanner;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Please, type phone number:");
        Scanner reader = new Scanner(System.in);
        String phoneNumber = reader.nextLine().replaceAll("[^0-9]+", "").trim();
        phoneNumber = Pattern.compile("(\\d)([\\d]{3})([\\d]{3})([\\d]{2})([\\d]{2})")
                .matcher(phoneNumber)
                .replaceAll("+7 $2 $3-$4-$5");
        System.out.println(phoneNumber);
    }
}
