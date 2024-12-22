import java.util.*;

public class Graph {
    private Map<String, Vertex> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addVertex(String name) {
        vertices.put(name, new Vertex(name));
    }

    public void addEdge(String from, String to, int weight) {
        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {
            throw new IllegalArgumentException("Vertex not found");
        }
        vertices.get(from).addNeighbor(to, weight);
        vertices.get(to).addNeighbor(from, weight); // For undirected graph
    }

    // Depth First Search to count paths
    public int countPaths(String start, String end) {
        return dfs(start, end, new HashSet<>());
    }

    private int dfs(String current, String end, Set<String> visited) {
        if (current.equals(end)) return 1;

        visited.add(current);
        int count = 0;
        for (String neighbor : vertices.get(current).getNeighbors().keySet()) {
            if (!visited.contains(neighbor)) {
                count += dfs(neighbor, end, visited);
            }
        }
        visited.remove(current);
        return count;
    }

    // Find paths with the smallest and largest number of nodes
    public void findPaths(String start, String end) {
        List<List<String>> paths = new ArrayList<>();
        findPathsHelper(start, end, new ArrayList<>(), paths);

        if (paths.isEmpty()) {
            System.out.println("No paths found.");
            return;
        }

        paths.sort(Comparator.comparingInt(List::size));

        System.out.println("Smallest path: " + paths.get(0) + ", Length: " + calculatePathCost(paths.get(0)));
        System.out.println("Largest path: " + paths.get(paths.size() - 1) + ", Length: " + calculatePathCost(paths.get(paths.size() - 1)));
    }

    private void findPathsHelper(String current, String end, List<String> path, List<List<String>> paths) {
        path.add(current);
        if (current.equals(end)) {
            paths.add(new ArrayList<>(path));
        } else {
            for (String neighbor : vertices.get(current).getNeighbors().keySet()) {
                if (!path.contains(neighbor)) {
                    findPathsHelper(neighbor, end, path, paths);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private int calculatePathCost(List<String> path) {
        int cost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            cost += vertices.get(path.get(i)).getNeighbors().get(path.get(i + 1));
        }
        return cost;
    }

    // Dijkstra's algorithm
    public void dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<VertexDistance> pq = new PriorityQueue<>(Comparator.comparingInt(VertexDistance::getDistance));

        for (String vertex : vertices.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new VertexDistance(start, 0));

        while (!pq.isEmpty()) {
            VertexDistance current = pq.poll();
            String currentVertex = current.getVertex();

            for (Map.Entry<String, Integer> neighbor : vertices.get(currentVertex).getNeighbors().entrySet()) {
                int newDist = distances.get(currentVertex) + neighbor.getValue();
                if (newDist < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDist);
                    previous.put(neighbor.getKey(), currentVertex);
                    pq.add(new VertexDistance(neighbor.getKey(), newDist));
                }
            }
        }

        System.out.println("Shortest path from " + start + " to " + end + ": " + buildPath(previous, start, end) + ", Cost: " + distances.get(end));
    }

    private List<String> buildPath(Map<String, String> previous, String start, String end) {
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    private static class VertexDistance {
        private final String vertex;
        private final int distance;

        public VertexDistance(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public String getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }
    }
}

