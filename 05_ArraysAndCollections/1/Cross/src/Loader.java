import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Введите длину стороны креста (нечетное целое число)");
        Scanner buffer = new Scanner(System.in);
        int lenCross = Integer.parseInt(buffer.nextLine());
        if (lenCross % 2 == 0) {
            lenCross += 1;
        }
        int lenCross2 = lenCross;
        char[][] arrCross = new char[lenCross][lenCross2];
        for (int i = 0; i < lenCross; i++) {
            for (int j = 0; j < lenCross2; j++) {
                if (j == i || j == lenCross - 1 - i) {
                    arrCross[i][j] = 'X';
                } else {
                    arrCross[i][j] = ' ';
                }
                System.out.print(arrCross[i][j]);
            }
            System.out.println("");
        }
    }
}
