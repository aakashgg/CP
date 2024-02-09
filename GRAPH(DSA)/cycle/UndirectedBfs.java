package cycle;

import java.util.*;

public class UndirectedBfs {
    private class Pair {
        int son;
        int parent;

        Pair(int son, int parent) {
            this.son = son;
            this.parent = parent;
        }
    }

    public class Bfs {
        public boolean cycle(List<List<Integer>> adj) {
            int[] vis = new int[adj.size()];
            for (int i = 0; i < adj.size(); i++) {
                if (vis[i] != 1)
                    if (cyclehelper(adj, vis, i)) {
                        return true;
                    }
            }
            return false;
        }

        private boolean cyclehelper(List<List<Integer>> adj, int[] vis, int src) {
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(src, -1));
            while (!q.isEmpty()) {
                int node = q.peek().son;
                int parent = q.peek().parent;
                vis[node] = 1;
                q.remove();
                for (int it : adj.get(node)) {
                    if (vis[it] != 1) {
                        q.add(new Pair(it, node));
                    } else if (parent != it) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
