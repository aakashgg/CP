import java.util.*;

public class BipartiteBfs {
    private boolean helper(ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        color[0] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    q.add(it);
                    color[it] = 1 - color[node];
                } else if (color[node] == color[it])
                    return false;
            }
        }

        return true;
    }

    public boolean bipartite(ArrayList<ArrayList<Integer>> adj) {
        int l = adj.size();
        int[] color = new int[l];
        Arrays.fill(color, -1);
        if (helper(adj, color) == false)
            return false;
        return true;
    }
}
