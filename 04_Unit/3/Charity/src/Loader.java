import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Please, type the count of boxes:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countOfBoxes;
        int numberOfContainer = 0;
        int numberOfTruck = 0;
        int boxesInContainer = 27;
        int containersInTruck = 12;
        try {
            countOfBoxes = Integer.parseInt(reader.readLine());
            for (int numberOfBox = 0; numberOfBox < countOfBoxes; ) {
                if (numberOfBox % boxesInContainer == 0) {
                    if (numberOfContainer % containersInTruck == 0) {
                        numberOfTruck++;
                        System.out.println("Truck " + numberOfTruck + ":");
                    }
                    numberOfContainer++;
                    System.out.println(" Container " + numberOfContainer + ":");
                }
                numberOfBox++;
                System.out.println("  Box " + numberOfBox);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
