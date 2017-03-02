public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length ==0) return 1;
        int m = dungeon.length, n = dungeon[0].length;

        int[][] needs = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = 0;
                if (i == m - 1 && j != n - 1) {
                    need = needs[i][j + 1] - dungeon[i][j];
                } else if (i != m - 1 && j == n - 1) {
                    need = needs[i + 1][j] - dungeon[i][j];
                } else if (i != m - 1 && j != n - 1) {
                    need = Math.min(needs[i + 1][j], needs[i][j + 1]) - dungeon[i][j];
                } else {
                    need = 1 - dungeon[m - 1][n - 1];
                }
                needs[i][j] = need > 0 ? need: 1;
            }
        }
        return needs[0][0];
    }
}
