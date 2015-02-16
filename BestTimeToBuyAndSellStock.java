package leetcode;

/**
 * Created by Lancer on 2/15/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int maxProfit = 0;
        int left, right, leftPos, rightPos;

        //max value and its position in prices
        rightPos = 0;
        right = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] <= right) continue;
            rightPos = i;
            right = prices[rightPos];
        }

        left = prices[0];
        for (int i = 1; i < len; i++) {

            if (left >= prices[i]){
                left=prices[i];
                continue;
            }

            leftPos = i - 1;
            //get the max value from leftPos+1 to the end of prices
            if (rightPos <= leftPos) {
                right=left;
                for (int j = i; j < len; j++) {
                    if (prices[j] <= right) continue;
                    rightPos = j;
                    right = prices[rightPos];
                }
            }
            if (right - left > maxProfit) maxProfit = right - left;
        }
        return maxProfit;
    }
}
