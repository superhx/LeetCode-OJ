public class Solution {
    private final static double PRECISE = 1e-5;

    public int mySqrt(int x) {
        double rst = x / 2 == 0 ? 1 : x / 2;
        while (Math.abs(rst * rst - x) > PRECISE)  {
            rst = rst / 2 + x / (2 * rst);
        }
        return (int) rst;
    }

}
