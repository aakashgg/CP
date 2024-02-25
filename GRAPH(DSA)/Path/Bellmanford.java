import java.util.*;

public class Bellmanford {
    // Adj -- AL has a list with 3 elements u v w
    public int[] path(ArrayList<ArrayList<Integer>> edges, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e8));
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);
                if (dist[u] != (int) (1e8) && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }

        }
        // Negavtive cycle the graph value should not decrease
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);
            if (dist[u] != (int) (1e8) && dist[u] < w + dist[v]) {
                return new int[] { -1 };

            }
        }

        return dist;
    }
}
