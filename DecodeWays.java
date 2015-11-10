class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') return 0;
        int[] nums = new int[len + 1];
        nums[0] = nums[1] = 1;
        for (int i = 2; i < len + 1; i++) {
            if (isLegal(s.substring(i - 1, i))) nums[i] = nums[i - 1];
            if (isLegal(s.substring(i - 2, i))) nums[i] += nums[i - 2];
        }
        return nums[len];
    }

    private boolean isLegal(String s) {
        int len = s.length();
        if (s.charAt(0) == '0') return false;
        if (len == 0 || len > 2) return false;
        if (Integer.parseInt(s) > 26) return false;
        return true;
    }
}
