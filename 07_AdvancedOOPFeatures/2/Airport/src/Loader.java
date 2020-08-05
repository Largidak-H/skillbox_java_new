import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.*;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> {
                    Calendar calendar = new GregorianCalendar();
                    calendar.add(Calendar.HOUR_OF_DAY, 2);
                    return f.getDate().after(new GregorianCalendar().getTime()) &&
                            f.getDate().before(calendar.getTime());
                })
                .sorted(Comparator.comparing(Flight::getDate))
                .forEach(System.out::println);
    }
}
