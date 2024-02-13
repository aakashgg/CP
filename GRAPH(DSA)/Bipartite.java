import java.util.*;
//  A bipartite graph is a graph in which 2 adjacent node cant have 
// same colour 

// can use any traversal technique
// use dfs or bfs

//Instead of visited use colour array 
//simple dfs chala colour kr aur agr already coloured h same colour 
//se to false dede.. bete
public class Bipartite {

    private boolean helper(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (helper(it, 1 - col, color, adj) == false)
                    return false;
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    public boolean bipartite(ArrayList<ArrayList<Integer>> adj) {
        int length = adj.size();
        int[] color = new int[length];
        Arrays.fill(color, -1);
        for (int i = 0; i < length; i++) {
            if (color[i] == -1) {
                if (helper(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}