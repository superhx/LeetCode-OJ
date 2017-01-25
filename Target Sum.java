public class Solution {
    // Convert problem to subset sum problem. And the target(sum + S) must be even.
    public int findTargetSumWays(int[] nums, int S) {
        int target = S;
        for(int num: nums) target += num;
        if (target / 2 < S || target % 2 > 0) return 0;
        target = target / 2;

        int [] dp = new int[target + 1];
        dp[0] = 1;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
