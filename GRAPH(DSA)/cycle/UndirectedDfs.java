package cycle;

import java.util.*;

public class UndirectedDfs {
    public boolean cycle(List<List<Integer>> adj) {
        int vis[] = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] != 1) {
                if (cyclehelper(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cyclehelper(int src, int parent, List<List<Integer>> adj, int vis[]) {
        vis[src] = 1;
        for (int it : adj.get(src)) {
            if (vis[it] != 1) {
                if (cyclehelper(it, src, adj, vis) == true)
                    return true;
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }

}
