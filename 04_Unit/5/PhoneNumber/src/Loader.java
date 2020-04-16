import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Please, type phone number:");
        Scanner reader = new Scanner(System.in);
        String phoneNumber = reader.nextLine().replaceAll("[^0-9]+", "").trim();
        if (phoneNumber.matches("[^7][\\d]{10}$")) {
            phoneNumber = phoneNumber.replace(phoneNumber.charAt(0), '7');
        }
        System.out.println(phoneNumber);
    }
}
