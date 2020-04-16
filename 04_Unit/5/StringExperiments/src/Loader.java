public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] strEarnings = text.replaceAll("[^0-9]+", " ").trim().split(" ");
        int sumOfEarnings = 0;
        for (String strEarning : strEarnings) sumOfEarnings += Integer.parseInt(strEarning);
        System.out.println("Общий заработок составил: " + sumOfEarnings + " руб.");
    }
}