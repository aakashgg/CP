package conversion;

import java.util.ArrayList;

class pair {
    int node;
    int w;

    public pair(int node, int w) {
        this.node = node;
        this.w = w;

    }
}

public class Sol {
    ArrayList<ArrayList<pair>> adj = new ArrayList<ArrayList<pair>>();

    private void convert(int[][] edges, int n) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<pair>());
        }
        // (u,v,w)

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }
    }

}