import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int INFINITY = Integer.MAX_VALUE;

        int[][] graph = {
            {0, 6, INFINITY, INFINITY, 7},
            {INFINITY, 0, 5, 4, 8},
            {INFINITY, INFINITY, 0, INFINITY, INFINITY},
            {2, INFINITY, 7, 0, INFINITY},
            {INFINITY, INFINITY, INFINITY, 9, 0}
        };
        
        int startNode = 0;
        
        int[] distances = bellmanFord(graph, startNode);
        
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + ": " + (distances[i] == INFINITY ? "Infinity" : distances[i]));
        }
    }

    public static int[] bellmanFord(int[][] graph, int start) {
        int n = graph.length;
        int INFINITY = Integer.MAX_VALUE;
        int[] distances = new int[n];
        Arrays.fill(distances, INFINITY);
        distances[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (graph[u][v] != INFINITY && distances[u] != INFINITY && distances[u] + graph[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph[u][v];
                    }
                }
            }
        }
        
        return distances;
    }
}
