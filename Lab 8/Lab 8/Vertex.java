import java.util.HashMap;
import java.util.Map;

public class Vertex {
    private String name;
    private Map<String, Integer> neighbors;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(String neighbor, int weight) {
        neighbors.put(neighbor, weight);
    }

    public Map<String, Integer> getNeighbors() {
        return neighbors;
    }

    public String getName() {
        return name;
    }
}
