package leetcode;

/**
 * Created by Lancer on 2/15/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;


        int[] leftMaxProfits = new int[len], rightMaxProfits = new int[len];
        int leftMaxProfit = 0, rightMaxProfit = 0;
        int leftMin = prices[0], rightMax = prices[len - 1];
        for (int i = 0; i < len; i++) {
            int left = prices[i];
            if (left > leftMin) {
                leftMaxProfit = left - leftMin > leftMaxProfit ? left - leftMin : leftMaxProfit;
            } else {
                leftMin = left;
            }
            leftMaxProfits[i] = leftMaxProfit;

            int right = prices[len - 1 - i];
            if (right < rightMax) {
                rightMaxProfit = rightMax - right > rightMaxProfit ? rightMax - right : rightMaxProfit;
            } else {
                rightMax = right;
            }
            rightMaxProfits[len-1-i]=rightMaxProfit;
        }

        int maxProfit = 0;
        if(maxProfit<rightMaxProfits[0]) maxProfit=rightMaxProfits[0];
        for(int i=1;i<len-1;i++){
            int temp=leftMaxProfits[i]+rightMaxProfits[i+1];
            if(maxProfit<temp) maxProfit=temp;
        }
        if(maxProfit<leftMaxProfits[len-1]) maxProfit=leftMaxProfits[len-1];

        return maxProfit;
    }
}
