public class MapApp {
    public static void main(String[] args) {
        // Create the graph
        Graph graph = new Graph();

        // Add vertices
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        for (String vertex : vertices) {
            graph.addVertex(vertex);
        }

        // Add edges
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "F", 2);
        graph.addEdge("B", "C", 11);
        graph.addEdge("B", "H", 14);
        graph.addEdge("C", "E", 4);
        graph.addEdge("C", "F", 3);
        graph.addEdge("D", "E", 6);
        graph.addEdge("D", "H", 15);
        graph.addEdge("E", "H", 12);
        graph.addEdge("F", "G", 16);
        graph.addEdge("G", "I", 8);
        graph.addEdge("H", "I", 13);
        graph.addEdge("H", "K", 12);
        graph.addEdge("I", "L", 17);
        graph.addEdge("J", "L", 18);

        // Task 4
        System.out.println("Number of paths from A to K:");
        System.out.println(graph.countPaths("A", "K"));

        System.out.println("Paths with smallest and largest number of nodes from A to K:");
        graph.findPaths("A", "K");

        // Task 5
        System.out.println("Shortest path from A to J:");
        graph.dijkstra("A", "J");

        System.out.println("Shortest path from B to L:");
        graph.dijkstra("B", "L");
    }
}
