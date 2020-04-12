public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String salaryOfVasya = text.substring(text.indexOf("заработал") + "заработал".length(), text.indexOf("рубл"));
        String salaryOfMasha = text.substring(text.indexOf("Маша -") + "Маша -".length(), text.lastIndexOf("рубл"));
        int earningOfVasya = Integer.parseInt(salaryOfVasya.trim());
        int earningOfMasha = Integer.parseInt(salaryOfMasha.trim());
        System.out.println("Вася и Маша вместе заработали: " + (earningOfVasya + earningOfMasha) + " руб.");
    }
}