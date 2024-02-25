package conversion;

import java.util.ArrayList;

public class Sol2 {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    public void convert(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
    }

}
