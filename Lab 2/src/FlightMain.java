import java.util.*;

class Flight {
    String flightId;
    String time;
    int priority;

    public Flight(String flightId, String time, int priority) {
        this.flightId = flightId;
        this.time = time;
        this.priority = priority;
    }

    public String getTime() {
        return time;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "(" + flightId + ", " + time + ")";
    }
}

class RunwaySchedule {

    // Function to schedule flights
    public static Map<Integer, List<Flight>> scheduleFlights(List<Flight> flights, int runways) {
        // Sort the flights first by priority (ascending, higher priority first) and then by time (ascending)
        Collections.sort(flights, (f1, f2) -> {
            if (f1.getPriority() != f2.getPriority()) {
                return Integer.compare(f1.getPriority(), f2.getPriority());
            } else {
                return f1.getTime().compareTo(f2.getTime());
            }
        });

        // Create a map to store the assigned flights on each runway
        Map<Integer, List<Flight>> runwayMap = new HashMap<>();
        for (int i = 1; i <= runways; i++) {
            runwayMap.put(i, new ArrayList<>());
        }

        // Assign flights to runways
        for (Flight flight : flights) {
            boolean assigned = false;

            // Try to assign the flight to a runway without a time conflict
            for (int i = 1; i <= runways; i++) {
                List<Flight> runwayFlights = runwayMap.get(i);

                boolean timeConflict = false;
                for (Flight f : runwayFlights) {
                    if (f.getTime().equals(flight.getTime())) {
                        timeConflict = true;
                        break;
                    }
                }

                // If no conflict, assign the flight to this runway
                if (!timeConflict) {
                    runwayFlights.add(flight);
                    assigned = true;
                    break;
                }
            }

            // If not assigned, output an error message
            if (!assigned) {
                System.out.println("Error: Could not schedule flight " + flight);
            }
        }

        // Ensure each runway is sorted by time after assignment
        for (int i = 1; i <= runways; i++) {
            List<Flight> runwayFlights = runwayMap.get(i);
            runwayFlights.sort(Comparator.comparing(Flight::getTime));
        }

        return runwayMap;
    }

    // Function to print the flights on each runway
    public static void printRunways(Map<Integer, List<Flight>> runwayMap) {
        for (int i = 1; i <= runwayMap.size(); i++) {
            System.out.println("Runway " + i + ": " + runwayMap.get(i));
        }
    }
}

public class FlightMain {
    public static void main(String[] args) {
        // Input
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("F1", "10:00", 2));
        flights.add(new Flight("F2", "09:30", 1));
        flights.add(new Flight("F3", "09:30", 2));
        flights.add(new Flight("F4", "11:00", 1));

        int runways = 2;

        
        Map<Integer, List<Flight>> runwaySchedule = RunwaySchedule.scheduleFlights(flights, runways);
        RunwaySchedule.printRunways(runwaySchedule);
    }
}
