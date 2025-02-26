package dsa.graph;

import java.util.*;

class AirlineRoutes {
    // Graph representation using an adjacency list
    private Map<String, List<String>> routeMap;

    // Constructor
    public AirlineRoutes() {
        this.routeMap = new HashMap<>();
    }

    // Method to add an airport (node)
    public void addAirport(String airport) {
        routeMap.putIfAbsent(airport, new ArrayList<>());
    }

    // Method to add a flight path (edge) between two airports
    public void addFlightPath(String airport1, String airport2, boolean isBidirectional) {
        routeMap.putIfAbsent(airport1, new ArrayList<>());
        routeMap.putIfAbsent(airport2, new ArrayList<>());

        routeMap.get(airport1).add(airport2);

        // If the flight is bidirectional, add the reverse path
        if (isBidirectional) {
            routeMap.get(airport2).add(airport1);
        }
    }

    // Method to display the airline route map
    public void displayRouteMap() {
        System.out.println("Airline Route Map (Graph Representation):");
        for (String airport : routeMap.keySet()) {
            System.out.println(airport + " --> " + routeMap.get(airport));
        }
    }

    // Main method to test the airline route system
    public static void main(String[] args) {
        AirlineRoutes airlineRoutes = new AirlineRoutes();

        // Adding airports (nodes)
        airlineRoutes.addAirport("JFK");  // New York
        airlineRoutes.addAirport("LAX");  // Los Angeles
        airlineRoutes.addAirport("ORD");  // Chicago
        airlineRoutes.addAirport("DFW");  // Dallas
        airlineRoutes.addAirport("ATL");  // Atlanta

        // Adding flight paths (edges)
        airlineRoutes.addFlightPath("JFK", "LAX", true);  // Bidirectional flight
        airlineRoutes.addFlightPath("JFK", "ORD", true);
        airlineRoutes.addFlightPath("ORD", "DFW", true);
        airlineRoutes.addFlightPath("DFW", "ATL", true);
        airlineRoutes.addFlightPath("ATL", "LAX", true);
        airlineRoutes.addFlightPath("JFK", "ATL", false); // One-way flight

        // Display the airline route system
        airlineRoutes.displayRouteMap();
    }
}

