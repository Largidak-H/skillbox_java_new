import com.skillbox.airport.*;

import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Aircraft> aircrafts = airport.getAllAircrafts();
        System.out.println(aircrafts.size());
    }
}
