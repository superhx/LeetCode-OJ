package leetcode;

public class Solution {
    public int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[] c = new int[tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            int old, prev = 0;
            for (int j = 0; j <= i && j <= tLen; j++) {
                old = c[j];
                c[j] = j == 0 ? 1 : old + (S.charAt(i - 1) == T.charAt(j - 1) ? prev : 0);
                prev = old;
            }
        }
        return c[tLen];
    }
}