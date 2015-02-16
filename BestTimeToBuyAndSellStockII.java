package leetcode;

/**
 * Created by Lancer on 2/15/15.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0,i=0;
        while (i<len){
            while (i<len-1&&prices[i]>=prices[i+1]) ++i;
            int min=prices[i++];
            while(i<len-1&&prices[i]<=prices[i+1]) ++i;
            profit+=i<len?prices[i++]-min:0;
        }
        return profit;
    }
}
