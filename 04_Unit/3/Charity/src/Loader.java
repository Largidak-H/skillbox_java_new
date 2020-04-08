import java.util.Scanner;

public class Loader {
    static final int BOXES_IN_CONTAINER = 27;
    static final int CONTAINERS_IN_TRUCK = 12;

    public static void main(String[] args) {
        System.out.println("Please, type the count of boxes:");
        Scanner reader = new Scanner(System.in);
        int countOfBoxes = reader.nextInt();
        int numberOfContainer = 0;
        int numberOfTruck = 0;
        for (int numberOfBox = 0; numberOfBox < countOfBoxes;) {
            if (numberOfBox % BOXES_IN_CONTAINER == 0) {
                if (numberOfContainer % CONTAINERS_IN_TRUCK == 0) {
                    numberOfTruck++;
                    System.out.println("Truck " + numberOfTruck + ":");
                }
                numberOfContainer++;
                System.out.println(" Container " + numberOfContainer + ":");
            }
            numberOfBox++;
            System.out.println("  Box " + numberOfBox);
        }
    }
}
