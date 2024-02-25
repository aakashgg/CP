import java.util.ArrayList;
import java.util.*;

class Pair implements Comparable<Pair> {
    int weight;
    int node;

    public Pair(int weight, int node) {
        this.weight = weight;
        this.node = node;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class dijkstra {

    public int[] shortestPath(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, (int) (1e9));
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, src));
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int weight = pq.peek().weight;
            pq.remove();
            for (ArrayList<Integer> it : adj.get(node)) {
                int currWeight = it.get(1);
                int currNode = it.get(0);
                if (currWeight + weight < dist[currNode]) {
                    dist[currNode] = currWeight + weight;
                    pq.add(new Pair(currWeight + weight, currNode));
                }
            }
        }

        return dist;
    }

}
