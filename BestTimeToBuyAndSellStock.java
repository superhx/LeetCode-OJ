class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > min) {
                maxProfit = maxProfit < prices[i] - min ? prices[i] - min : maxProfit;
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}
