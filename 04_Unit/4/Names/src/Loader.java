import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        String surname = null;
        String name = null;
        String middleName = null;
        System.out.println("Пожалуйста, введите через пробел Ваши Фамилию, Имя и Отчество:");
        Scanner reader = new Scanner(System.in);
        String startString = reader.nextLine().trim();
        if (!startString.equals("")) {
            try {
                surname = startString.substring(0, startString.indexOf(" "));
                String withoutSurname = startString.substring(surname.length()).trim();
                try {
                    name = withoutSurname.substring(0, withoutSurname.indexOf(" "));
                    String withoutSurnameAndName = withoutSurname.substring(name.length()).trim();
                    try {
                        middleName = withoutSurnameAndName.substring(0, withoutSurnameAndName.indexOf(" "));
                    } catch (Exception e2) {
                        middleName = withoutSurnameAndName;
                        e2.getMessage();
                    }
                } catch (Exception e1) {
                    name = withoutSurname;
                    e1.getMessage();
                }
            } catch (Exception e) {
                surname = startString;
                e.getMessage();
            }
        }
        System.out.println("Фамилия: " + surname + "\nИмя: " + name + "\nОтчество: " + middleName);
    }
}
