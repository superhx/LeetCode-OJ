public class Solution {
    // convert problem to subset sum problem
    public int findTargetSumWays(int[] nums, int S) {
        int target = S;
        for(int num: nums) target += num;
        if (target / 2 < S) return 0;
        for(int i = 0; i < nums.length; i++) nums[i] *= 2;

        int[][] dp = new int[target + 1][nums.length + 1];
        dp[0][0] = 1;
        for(int i = 0; i < target + 1; i++) {
            for(int j = 1; j < nums.length + 1; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i - nums[j - 1] >= 0) dp[i][j] += dp[i - nums[j - 1]][j - 1];
            }
        }
        return dp[dp.length - 1][nums.length];
    }
}
