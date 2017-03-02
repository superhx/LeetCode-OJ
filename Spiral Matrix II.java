public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int cur = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) matrix[i][j] = ++cur;
            for (int j = i; j < n - i - 1; j++) matrix[j][n - i - 1] = ++cur;
            for (int j = n - i - 1; j > i; j--) matrix[n - i - 1][j] = ++cur;
            for (int j = n - i - 1; j > i; j--) matrix[j][i] = ++cur;
        }
        if (n % 2 != 0) matrix[n/2][n/2] = ++cur;
        return matrix;
    }
}
