public class Loader {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] rainbow = text.split(",?\\s+");
        for (String item : rainbow) {
            System.out.println(item);
        }
        for (int i = 0; i < rainbow.length / 2; i++) {
            String buffer = rainbow[i];
            rainbow[i] = rainbow[rainbow.length - 1 - i];
            rainbow[rainbow.length - 1 - i] = buffer;
        }
        for (String item : rainbow) {
            System.out.println(item);
        }
    }
}
