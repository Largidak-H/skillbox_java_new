public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        sumDigits(11111);

    }

    public static Integer sumDigits(Integer number)
    {
        int sum = 0;

        int sumCh1 = 0; // with * №1
        int sumCh2 = 0; // with * №2

        String sDigit = number.toString();
        for (int i = 0; i < sDigit.length(); i++) {
            sum += Integer.parseInt(String.valueOf(sDigit.charAt(i)));

            sumCh1 += Character.getNumericValue(sDigit.charAt(i)); // with * №1
            sumCh2 += Character.digit(sDigit.charAt(i), 10); // with * №2
        }
        System.out.println("sum = " + sum + ", sumCh1 = " + sumCh1 + ", sumCh2 = " + sumCh2);
        return sum;
    }
}
