import java.util.*;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        char[] symbols = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        int [] digitsOfRegions = new int[200];

        for (int i=1;i<digitsOfRegions.length;i++) {
            digitsOfRegions[i]=i;
        }

        ArrayList<String> listOfNiceNumbers = new ArrayList<>();

        int countOfNumbers = 1000;

        for (char symbol : symbols) {
            for (int numbers = 0; numbers < countOfNumbers; numbers++) {
                String number = String.format("%1$c%2$03d%1$c%1$c", symbol, numbers);
                if (!listOfNiceNumbers.contains(number)) {
                    listOfNiceNumbers.add(number);
                }
            }
        }

        int countOfDigits = 10;

        for (char symbol1 : symbols) {
            for (char symbol2 : symbols) {
                for (char symbol3 : symbols) {
                    for (int digits = 0; digits < countOfDigits; digits++) {
                        String number = String.format("%2$c%1$d%1$d%1$d%3$c%4$c", digits, symbol1, symbol2, symbol3);
                        if (!listOfNiceNumbers.contains(number))
                            listOfNiceNumbers.add(number);
                        number = String.format("%2$c%1$d00%3$c%4$c", digits, symbol1, symbol2, symbol3);
                        if (!listOfNiceNumbers.contains(number))
                            listOfNiceNumbers.add(number);
                    }
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();

        for (String number : listOfNiceNumbers)
            for (int region : digitsOfRegions)
            {
                result.add(String.format("%1$s%2$02d", number, region));
            }

        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Пожалуйста, введите номер автомобиля:");
            String ourNumber = reader.nextLine().trim().toUpperCase();
            if (!Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d[1-9]+$").matcher(ourNumber).matches())
                System.out.println("Неверно введен номер");
            else {
                HashSet<String> resultHash = new HashSet<>(result);
                TreeSet<String> resultTree = new TreeSet<>(result);

                long startTime = System.nanoTime();
                boolean blat = result.contains(ourNumber);
                long finTime = System.nanoTime();
                System.out.println("Поиск перебором: " + checkBlat(blat) + "поиск занял " + (finTime - startTime) + "нс");

                Collections.sort(result);
                long startTimeBin = System.nanoTime();
                int a = Collections.binarySearch(result,ourNumber);
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
        return b > 0 ? "номер найден, " : "номер не найден, ";
    }
}
