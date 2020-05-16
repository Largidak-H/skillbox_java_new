import java.util.Scanner;
import java.util.TreeSet;

public class Loader {
    public static TreeSet<String> emails = new TreeSet<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите команду управления e-mail: ");
            Scanner reader = new Scanner(System.in);
            String commandLine = reader.nextLine();
            String[] arrCommand = commandLine.split("\\s+");
            String commandItem = arrCommand[0].trim().toUpperCase();
            switch (commandItem) {
                case ("LIST"):
                    if (!emails.isEmpty()) {
                        for (String eItem : emails) {
                            System.out.println(eItem);
                        }
                    } else {
                        System.out.println("Список e-mail пуст.");
                    }
                    break;
                case ("ADD"):
                    if (arrCommand.length == 2 && isEmail(arrCommand[1])) {
                        emails.add(arrCommand[1]);
                        System.out.println("E-mail успешно добавлен в коллекцию.");
                    } else {
                        System.out.println("Неверно введен e-mail!");
                    }
                    break;
                default:
                    System.out.println("Неверно введена команда!");
                    break;
            }
        }
    }

    public static boolean isEmail(String eStr) {
        return eStr.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }
}
