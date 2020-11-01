import core.Line;
import core.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest {

    StationIndex stationIndex;
    RouteCalculator routeCalculator;
    List<Station> route;

    @Before
    public void setUp() {

        Line line1 = new Line(1, "Именная");
        Line line2 = new Line(2, "Плодовая");
        Line line3 = new Line(3, "Водная");

        Station station1 = new Station("Петровская", line1);
        Station station2 = new Station("Ивановская", line1);
        Station station3 = new Station("Семеновская", line1);
        Station station4 = new Station("Ильинская", line1);
        Station station5 = new Station("Арбузная", line2);
        Station station6 = new Station("Яблочная", line2);
        Station station7 = new Station("Морковная", line2);
        Station station8 = new Station("Абрикосовая", line2);
        Station station9 = new Station("Прудовая", line3);
        Station station10 = new Station("Озерная", line3);
        Station station11 = new Station("Речная", line3);
        Station station12 = new Station("Морская", line3);

        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line1.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station6);
        line2.addStation(station7);
        line2.addStation(station8);
        line3.addStation(station9);
        line3.addStation(station10);
        line3.addStation(station11);
        line3.addStation(station12);

        stationIndex = new StationIndex();

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);
        stationIndex.addStation(station10);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(station3, station6)));
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(station7, station10)));

        routeCalculator = new RouteCalculator(stationIndex);

        route = new ArrayList<>();

        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station6);
        route.add(station7);
        route.add(station10);
        route.add(station11);
    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),
                stationIndex.getStation("Семеновская"));
        List<Station> expected = new ArrayList<>(route.subList(0, 3));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),
                stationIndex.getStation("Морковная"));
        List<Station> expected = new ArrayList<>(route.subList(0, 5));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),
                stationIndex.getStation("Речная"));
        List<Station> expected = new ArrayList<>(route.subList(0, 7));
        Assert.assertEquals(expected, actual);
    }
}
