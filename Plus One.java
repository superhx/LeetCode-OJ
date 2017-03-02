public class Solution {
    public int[] plusOne(int[] digits) {
        int[] rst = new int[digits.length + 1];
        List<Integer> list = new ArrayList<>(digits.length + 1);

        int in = 1;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            rst[i + 1] = (digits[i] + in) % 10;
            in = (digits[i] + in) / 10;
        }

        if (in == 0) return Arrays.copyOfRange(rst, 1, rst.length);
        rst[0] = in;
        return rst;
    }
}
