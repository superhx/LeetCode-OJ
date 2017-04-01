public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        boolean positive = true;
        if (((dividend ^ divisor) & (1 << 31)) == (1 << 31)) positive = false;
        long dividendL = dividend, divisorL = divisor;
        if (dividend < 0) dividendL = - dividendL;
        if (divisor < 0) divisorL = - divisorL;
        int res = 0;
        while (dividendL >= divisorL) {
            int mul = 1;
            long div = divisorL;
            while (dividendL >= div) {
                res += mul;
                dividendL -= div;
                div <<= 1;
                mul <<= 1;
            }
        }
        return positive ? res: -res;
    }
}
