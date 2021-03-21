import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
//        UndergroundSystem undergroundSystem = new UndergroundSystem();
//        undergroundSystem.checkIn(10, "Leyton", 3);
//        undergroundSystem.checkOut(10, "Paradise", 8);
//        undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000
//        undergroundSystem.checkIn(5, "Leyton", 10);
//        undergroundSystem.checkOut(5, "Paradise", 16);
//        undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000
//        undergroundSystem.checkIn(2, "Leyton", 21);
//        undergroundSystem.checkOut(2, "Paradise", 30);
//        undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        undergroundSystem.getAverageTime("Paradise", "Cambridge");       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");          // return 12.00000
    }
}

class UndergroundSystem {

    class Trip {
        Station station;
        int start;
        int end;

        public Trip() {
            this.station = new Station();
        }
    }

    class Station {
        String startStation;
        String endStation;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Station station = (Station) o;
            return Objects.equals(startStation, station.startStation) && Objects.equals(endStation, station.endStation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startStation, endStation);
        }

        public Station() {

        }
    }

    class Pair {
        double sum;
        double amount;

        public Pair(double sum, double amount) {
            this.sum = sum;
            this.amount = amount;
        }
    }

    private Map<Integer, Trip> map = new HashMap<>();
    private Map<Station, Pair> average = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        Trip trip = new Trip();
        trip.station.startStation = stationName;
        trip.start = t;
        map.put(id, trip);
    }

    public void checkOut(int id, String stationName, int t) {
        Trip trip = map.get(id);
        trip.station.endStation = stationName;
        trip.end = t;
        map.put(id, trip);
        Pair p = average.getOrDefault(trip.station, new Pair(0, 0));
        p.sum += (trip.end - trip.start);
        p.amount++;
        average.put(trip.station, p);
    }

    public double getAverageTime(String startStation, String endStation) {
        Station s = new Station();
        s.startStation = startStation;
        s.endStation = endStation;
        Pair p = average.get(s);
        double result = p.sum / p.amount;
        System.out.println(result);
        return result;
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such: UndergroundSystem obj = new
 * UndergroundSystem(); obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3 =
 * obj.getAverageTime(startStation,endStation);
 */