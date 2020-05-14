import java.util.ArrayList;
import java.util.Scanner;

public class Loader {
    public static ArrayList<String> matters = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите команду управления списком дел: ");
            Scanner reader = new Scanner(System.in);
            String commandLine = reader.nextLine();
            String[] arrCommand = commandLine.split("\\s+");
            String commandItem = arrCommand[0].trim().toUpperCase();
            switch (commandItem) {
                case ("LIST"):
                    if (!matters.isEmpty()) {
                        for (int i = 0; i < matters.size(); i++) {
                            System.out.printf("%d %s%n", i, matters.get(i));
                        }
                    } else {
                        System.out.println("Список дел пуст.");
                    }
                    break;
                case ("ADD"):
                    if (arrCommand.length > 2 && isNumber(arrCommand[1])) {
                        int place = detPlace(arrCommand[1]);
                        if (place > matters.size() - 1) {
                            matters.add(getCommandText(2, arrCommand));
                            System.out.println("Дело успешно добавлено в конец списка.");
                            continue;
                        }
                        matters.add(place, getCommandText(2, arrCommand));
                        System.out.printf("Дело успешно добавлено на %d место.%n", place);
                    } else if (arrCommand.length > 1 && !isNumber(arrCommand[1])) {
                        matters.add(getCommandText(1, arrCommand));
                        System.out.println("Дело успешно добавлено в конец списка.");
                    } else {
                        System.out.println("Неверно введена команда ADD");
                    }
                    break;
                case ("EDIT"):
                    if (arrCommand.length > 2 && isNumber(arrCommand[1])) {
                        int place = detPlace(arrCommand[1]);
                        if (place > matters.size() - 1) {
                            System.out.println("Неверно введена команда EDIT");
                            break;
                        }
                        matters.set(place, getCommandText(2, arrCommand));
                        System.out.printf("Дело на %d месте успешно изменено.%n", place);
                    } else {
                        System.out.println("Неверно введена команда EDIT");
                    }
                    break;
                case ("DELETE"):
                    if (arrCommand.length == 2 && isNumber(arrCommand[1])) {
                        int place = detPlace(arrCommand[1]);
                        if (place > matters.size() - 1) {
                            System.out.println("Неверно введена команда DELETE");
                            break;
                        }
                        matters.remove(place);
                        System.out.printf("Дело успешно удалено с %d места.%n", place);
                    } else {
                        System.out.println("Неверно введена команда DELETE");
                    }
                    break;
                default:
                    System.out.println("Неверно введена команда!");
                    break;
            }
        }
    }

    public static boolean isNumber(String placeStr) {
        return placeStr.matches("^-?\\d+$");
    }

    public static int detPlace(String placeStr) {
        return Integer.parseInt(placeStr);
    }

    public static String getCommandText(int initWord, String[] arrString) {
        StringBuilder builder = new StringBuilder();
        for (; initWord < arrString.length; initWord++) {
            builder.append(arrString[initWord]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

}
