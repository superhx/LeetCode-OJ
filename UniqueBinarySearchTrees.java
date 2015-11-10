class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - 1 - j];
            }
        }
        return nums[n];
    }
}
