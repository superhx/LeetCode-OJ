public class Solution {
   public int uniquePathsWithObstacles(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        if (grid[0][0] == 1) return 0;
        int m = grid.length, n = grid[0].length;
        int[] ways = new int[m];
        ways[0] = 1;
        for (int i = 1; i < m; i++) ways[i] = grid[i][0] == 1 ? 0: ways[i] + ways[i - 1];

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    ways[i] = 0;
                } else if (i == 0){
                    ways[i] = grid[0][j] == 1 ? 0: ways[i];
                } else {
                    ways[i] += ways[i - 1];
                }
            }
        }

        return ways[m - 1];
    }
}
