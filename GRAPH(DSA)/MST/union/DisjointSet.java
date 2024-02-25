package MST.union;

public class DisjointSet {
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
            sizeArray[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);// Path compression
        }
        return x;

    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
        // find ultimate parent
        int rootX = find(x);
        int rootY = find(y);
        // if (rootX != rootY) {
        // if (rank[rootX] < rank[rootY]) {
        // parent[rootX] = rootY;
        // } else if (rank[rootY] > rank[rootX]) {
        // parent[rootX] = rootY;
        // } else {
        // parent[rootY] = rootX;
        // rank[rootX]++;
        // }
        // }

        if (rootX != rootY) {
            if (sizeArray[rootX] < sizeArray[rootY]) {
                parent[rootX] = rootY;
                sizeArray[rootY] += sizeArray[rootX];
            } else {
                parent[rootY] = rootX;
                sizeArray[rootX] += sizeArray[rootY];
            }
        }
    }

}
