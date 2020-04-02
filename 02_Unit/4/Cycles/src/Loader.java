public class Loader
{
    public static void main(String[] args) {

        for (int i = 200000; i<=210000; i++ ) {
            System.out.println(i);
        }

        for (int j = 220000; j<=235000; j++ ) {
            System.out.println(j);
        }

        System.out.println("=======================");

        int a = 200000;
        while (a<=235000) {
            if (!(a>210000 && a<220000)) {
                System.out.println(a);
            }
            a++;
        }
    }
}
