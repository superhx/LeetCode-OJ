public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length, width = grid[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (i !=0 && j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else if (i !=0 && j != 0){
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[height - 1][width - 1];
    }
}
