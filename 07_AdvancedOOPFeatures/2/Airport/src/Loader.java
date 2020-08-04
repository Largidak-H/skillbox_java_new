import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Terminal> terminalList = airport.getTerminals();
        List<Flight> flightList = new ArrayList<>();
        terminalList.forEach(t -> flightList.addAll(t.getFlights()));
        flightList.stream()
                .filter(f -> f.getType().equals(Flight.Type.ARRIVAL))
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
