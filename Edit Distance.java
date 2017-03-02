public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        int[] distances = new int[m + 1];

        for (int i = 0; i < m + 1; i++) distances[i] = i;

        for (int j = 1; j < n + 1; j++) {
            int pre = distances[0];
            distances[0] = j;
            for (int i = 1; i < m + 1; i++) {
                int temp = distances[i];
                if (word2.charAt(j - 1) == word1.charAt(i - 1)) {
                    distances[i] = pre;
                } else {
                    distances[i] = Math.min(pre, Math.min(distances[i], distances[i - 1]));
                    distances[i]++;
                }
                pre = temp;
            }
        }
        return distances[m];
    }
    // Basic DP solution
    // ------------------------------------------------------------
    // int m = word1.length(), n = word2.length();
    // int[][] distances = new int[m + 1][n + 1];

    // for (int i = 0; i < m + 1; i++) distances[i][0] = i;
    // for (int j = 0; j < n + 1; j++) distances[0][j] = j;

    // for (int i = 1; i < m + 1; i++) {
    //     for (int j = 1; j < n + 1; j++) {
    //         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    //             distances[i][j] = distances[i - 1][j - 1];
    //         } else {
    //             distances[i][j] = Math.min(Math.min(distances[i][j - 1], distances[i - 1][j]), distances[i - 1][j - 1]);
    //             distances[i][j]++;
    //         }
    //     }
    // }

    // return distances[m][n];
    // ------------------------------------------------------------
}
