import java.util.*;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        char[] symbols = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

       ArrayList<String> listOfNiceNumbers = new ArrayList<>();

        for (char symbol1 : symbols) {
            for (char symbol2 : symbols) {
                for (char symbol3 : symbols) {
                    for (int digits = 111; digits <= 999; digits += 111) {
                        for (int region = 1; region <= 200; region++) {
                            String number = String.format("%2$c%1$d%3$c%4$c%5$02d", digits, symbol1, symbol2, symbol3, region);
                            listOfNiceNumbers.add(number);
                        }
                    }
                }
            }
        }

        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Пожалуйста, введите номер автомобиля:");
            String ourNumber = reader.nextLine().trim().toUpperCase();
            if (!Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d[1-9]+$").matcher(ourNumber).matches())
                System.out.println("Неверно введен номер");
            else {
                HashSet<String> resultHash = new HashSet<>(listOfNiceNumbers);
                TreeSet<String> resultTree = new TreeSet<>(listOfNiceNumbers);

                long startTime = System.nanoTime();
                boolean blat = listOfNiceNumbers.contains(ourNumber);
                long finTime = System.nanoTime();
                System.out.println("Поиск перебором: " + checkBlat(blat) + "поиск занял " + (finTime - startTime) + "нс");

                Collections.sort(listOfNiceNumbers);
                long startTimeBin = System.nanoTime();
                int a = Collections.binarySearch(listOfNiceNumbers,ourNumber);
                long finTimeBin = System.nanoTime();
                System.out.println("Бинарный поиск: " + checkBlat(a) + "поиск занял " + (finTimeBin - startTimeBin) + "нс");

                long startTimeHash = System.nanoTime();
                boolean blatHash = resultHash.contains(ourNumber);
                long finTimeHash = System.nanoTime();
                System.out.println("Поиск в HashSet: " + checkBlat(blatHash) + "поиск занял " + (finTimeHash - startTimeHash) + "нс");

                long startTimeTree = System.nanoTime();
                boolean blatTree = resultTree.contains(ourNumber);
                long finTimeTree = System.nanoTime();
                System.out.println("Поиск в TreeSet: " + checkBlat(blatTree) + "поиск занял " + (finTimeTree - startTimeTree) + "нс");
            }
        }
    }

    private static String checkBlat(boolean blat) {
        return blat ? "номер найден, " : "номер не найден, ";
    }

    private static String checkBlat(int b) {
        return b >= 0 ? "номер найден, " : "номер не найден, ";
    }
}
