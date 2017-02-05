public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int cur = nums[0], len = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur && ++count > 2) continue;
            if (nums[i] != cur) count = 1;
            System.out.println(nums[i] + " " + cur + " " + count);
            cur = nums[i];
            nums[len++] = cur;
        }
        return len;
    }
}
