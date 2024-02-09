package cycle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedBfs {
    public boolean kahncycle(List<List<Integer>> adj) {
        int n = adj.size();
        int[] topo = new int[n];
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        // Indegree Created

        // check if theres 0 indegree
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            i++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return n == i;

    }

}
