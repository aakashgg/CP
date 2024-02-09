import java.util.*;

public class DFS {
    public List<Integer> dfs(List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        int n = adj.size();
        int[] vis = new int[n];
        for(int i =0;i<n;i++){
            if(vis[i]!=1){
        dfshelper(i, vis, adj, ans);
            }
        }
        return ans;
    }

    private void dfshelper(int curr, int[] vis, List<List<Integer>> adj, List<Integer> ans) {
        vis[curr] = 1;
        ans.add(curr);
        for (int it : adj.get(curr)) {
            if (vis[it] != 1) {
                dfshelper(it, vis, adj, ans);
            }
        }

    }

}