public class Solution {
   public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m > n) return uniquePaths(n, m);
        int[] ways = new int[m];
        Arrays.fill(ways, 1);

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                ways[i] += ways[i - 1];
            }
        }

        return ways[m - 1];
    }

}
