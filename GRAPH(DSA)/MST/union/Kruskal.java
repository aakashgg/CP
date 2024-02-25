package MST.union;

import java.util.*;

class DisjointSet {
    private int[] rank;
    private int[] parent;
    private int[] sizeArray;

    public DisjointSet(int size) {
        rank = new int[size];
        parent = new int[size];
        sizeArray = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
            sizeArray[i] = 1; // Initialize size as 1 for each set
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                sizeArray[rootY] += sizeArray[rootX];
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                sizeArray[rootX] += sizeArray[rootY];
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
                sizeArray[rootX] += sizeArray[rootY];
            }
        }
    }
}

public class Kruskal {
    static class Group {
        int u;
        int v;
        int w;

        public Group(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int kruskalMST(int n, int[][] edges) {
        PriorityQueue<Group> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        for (int i = 0; i < edges.length; i++) {
            pq.add(new Group(edges[i][0], edges[i][1], edges[i][2]));
        }
        DisjointSet ds = new DisjointSet(n + 1);
        int cost = 0;
        int edgeCount = 0;

        while (!pq.isEmpty() && edgeCount < n - 1) {
            Group edge = pq.poll();
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;
            if (!ds.isConnected(u, v)) {
                ds.union(u, v);
                cost += w;
                edgeCount++;
            }
        }

        return cost;
    }
}
