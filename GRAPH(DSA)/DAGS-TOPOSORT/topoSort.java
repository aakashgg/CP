import java.util.*;

public class topoSort {
    public List<Integer> topo(List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = adj.size();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                dfs(i, vis, adj, stack);
            }
        }
        for (int i = 0; i < n; i++) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private void dfs(int curr, int[] vis, List<List<Integer>> adj, Stack<Integer> stack) {
        vis[curr] = 1;
        stack.push(curr);
        for (int it : adj.get(curr)) {
            if (vis[it] != 1) {
                dfs(it, vis, adj, stack);
            }
        }

    }
}
