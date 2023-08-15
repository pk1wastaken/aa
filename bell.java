import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int[][] graph = {
            {0, 6, Integer.MAX_VALUE, Integer.MAX_VALUE, 7},
            {Integer.MAX_VALUE, 0, 5, 4, 8},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {2, Integer.MAX_VALUE, 7, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, 0}
        };
        
        int startNode = 0;
        
        int[] distances = bellmanFord(graph, startNode);
        
        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + ": " + (distances[i] == Integer.MAX_VALUE ? "Infinity" : distances[i]));
        }
    }

    public static int[] bellmanFord(int[][] graph, int start) {
        int n = graph.length;
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (graph[u][v] != Integer.MAX_VALUE && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v]) {
                        distances[v] = distances[u] + graph[u][v];
                    }
                }
            }
        }
        
        return distances;
    }
}
