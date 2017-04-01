public class Solution {
    public int removeElement(int[] nums, int val) {
        int mark = nums.length - 1;
        while (mark >= 0 && nums[mark] == val) mark--;
        int index = mark - 1;
        for (int i = mark - 1; i >= 0; i--) {
            if (nums[i] != val) continue;
            int temp = nums[mark];
            nums[mark--] = nums[i];
            nums[i] = temp;
        }
        return mark + 1;
    }
}
