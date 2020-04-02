public class Loader
{
    public static void main(String[] args) {
        Integer dimaAge = 10;
        Integer mishaAge = 10;
        Integer vasyaAge = 10;

        Integer max = dimaAge;
        Integer min = dimaAge;
        Integer middle =dimaAge;

        if (min >= mishaAge) {
            min = mishaAge;
        }
        else {
            middle = mishaAge;
        }

        if (min >= vasyaAge) {
            max = middle;
            middle= min;
            min = vasyaAge;
        } else if (middle <= vasyaAge) {
            max = vasyaAge;
        }
        else {
            max = middle;
            middle = vasyaAge;
        }

        System.out.println("Minimal age: " + min);
        System.out.println("Middle age: " + middle);
        System.out.println("Maximum age: " + max);
    }
}
