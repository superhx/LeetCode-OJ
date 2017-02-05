public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int cur = nums[0], len = 1, tail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) continue;
            cur = nums[i];
            nums[len] = cur;
            len++;
        }
        return len;
    }
}
