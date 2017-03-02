public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int red = 0, blue = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (i > blue) break;
            switch (nums[i]) {
                case 0:
                    swap(nums, red++, i);
                    break;
                case 2:
                    swap(nums, blue--, i--);
                    break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
