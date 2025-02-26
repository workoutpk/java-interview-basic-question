package dsa.graph;

import java.util.*;

class RoadSystem {
    // Graph representation using an adjacency list
    private Map<String, List<String>> roadMap;

    // Constructor
    public RoadSystem() {
        this.roadMap = new HashMap<>();
    }

    // Method to add an intersection (vertex)
    public void addIntersection(String intersection) {
        roadMap.putIfAbsent(intersection, new ArrayList<>());
    }

    // Method to add a road (edge) between two intersections
    public void addRoad(String intersection1, String intersection2) {
        roadMap.putIfAbsent(intersection1, new ArrayList<>());
        roadMap.putIfAbsent(intersection2, new ArrayList<>());

        roadMap.get(intersection1).add(intersection2);
        roadMap.get(intersection2).add(intersection1); // Since roads are bidirectional
    }

    // Method to display the road system
    public void displayRoadSystem() {
        System.out.println("Road System (Graph Representation):");
        for (String intersection : roadMap.keySet()) {
            System.out.println(intersection + " --> " + roadMap.get(intersection));
        }
    }

    // Main method to test the road system
    public static void main(String[] args) {
        RoadSystem roadSystem = new RoadSystem();

        // Adding intersections (vertices)
        roadSystem.addIntersection("A");
        roadSystem.addIntersection("B");
        roadSystem.addIntersection("C");
        roadSystem.addIntersection("D");

        // Adding roads (edges)
        roadSystem.addRoad("A", "B");
        roadSystem.addRoad("A", "C");
        roadSystem.addRoad("B", "D");
        roadSystem.addRoad("C", "D");

        // Display the road system
        roadSystem.displayRoadSystem();
    }
}

