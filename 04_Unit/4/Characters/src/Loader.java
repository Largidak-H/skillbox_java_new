public class Loader {
    public static void main(String[] args) {
        for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
            System.out.println((char) i + " = " + i + ", " + (char) (i + 32) + " = " + (i + 32));
        }
    }
}
