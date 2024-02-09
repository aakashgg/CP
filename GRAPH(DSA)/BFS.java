import java.util.*;

public class BFS {
    public static List<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();
        int[] vis = new int[n];
        q.add(0);
        vis[0] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int it : adj.get(curr)) {
                if (vis[it] == 0) {
                    q.add(it);
                    vis[it] = 1;
                }
            }
        }

        return ans;
    }

}