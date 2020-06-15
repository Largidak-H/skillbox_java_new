import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду \"LIST\", Ф.И.О. абонента или номер телефона абонента:");
            String command = reader.nextLine().trim();
            if (command.equalsIgnoreCase("LIST")) {
                if (!phoneBook.isEmpty()) {
                    printMap(phoneBook);
                } else System.out.println("Телефонная книга пуста.");
            } else {
                if (Pattern.compile("^[А-ЯЁа-яё&&[^ЪЬЫъыь]]+\\s[А-ЯЁа-яё&&[^ЪЬЫъыь]]+\\s[А-ЯЁа-яё&&[^ЪЬЫъыь]]+$")
                        .matcher(command).matches()) {
                    if (phoneBook.containsValue(command)) {
                        for (Map.Entry entry : phoneBook.entrySet()) {
                            if (entry.getValue().equals(command)) {
                                System.out.println(command + ", номер телефона: " + entry.getKey());
                            }
                        }
                    } else {
                        System.out.println("Абонента с таким Ф.И.О в телефонной книге нет. " +
                                "Пожалуйста, введите номер телефона абонента (10-11 цифр):");
                        String phoneNumber = reader.nextLine().replaceAll("[^0-9]+", "").trim();
                        if (Pattern.compile("^[0-9]{10,11}+$").matcher(phoneNumber).matches()) {
                            phoneNumber = checkNumber(phoneNumber);
                            phoneBook.put(phoneNumber, command);
                            System.out.println("Номер телефонна введен успешно.");
                        } else
                            System.out.println("Номер телефонна введен неверно!");
                    }
                } else if (Pattern.compile("^[0-9]{10,11}+$").matcher(command = command.replaceAll("[^0-9]+",
                        "").trim()).matches()) {
                    command = checkNumber(command);
                    if (phoneBook.containsKey(command)) {
                        System.out.println(phoneBook.get(command) + ", номер телефона: " + command);
                    } else {
                        System.out.println("Абонента с таким номером телефона в телефонной книге нет. " +
                                "Пожалуйста, введите Ф.И.О. абонента:");
                        String name = reader.nextLine().trim();
                        if (Pattern.compile("^[А-ЯЁа-яё&&[^ЪЬЫъыь]]+\\s[А-ЯЁа-яё&&[^ЪЬЫъыь]]+\\s[А-ЯЁа-яё&&[^ЪЬЫъыь]]+$")
                                .matcher(name).matches()) {
                            phoneBook.put(command, name);
                            System.out.println("Ф.И.О. введены успешно.");
                        } else
                            System.out.println("Ф.И.О. введены не верно.");
                    }
                } else {
                    System.out.println("Ввод осуществлен неверно!");
                }
            }
        }
    }

    private static void printMap(Map<String, String> anyMap) {
        for (String key : anyMap.keySet()) {
            System.out.println(anyMap.get(key) + ", номер телефона: " + key);
        }
    }

    private static String checkNumber(String number) {
        if (number.length() == 11) {
            number = number.substring(1);
        }
        number = 7 + number;
        return number;
    }
}
