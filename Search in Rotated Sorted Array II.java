public class Solution {
   public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private boolean search(int[] nums, int target, int start, int end) {
        if (start >= end) return false;
        if (start == end - 1) return target == nums[start];

        if (nums[start] < nums[end - 1]) return binarySearch(nums, target, start, end);

        int mid = (start + end) / 2;
        return search(nums, target, start, mid) || search(nums, target, mid, end);
    }

    private boolean binarySearch(int[] nums, int target, int start, int end) {
        if (start >= end) return false;
        int mid = (start + end) / 2;
        if (target == nums[mid]) return true;
        if (target < nums[mid]) return binarySearch(nums, target, start, mid);
        if (target > nums[mid]) return binarySearch(nums, target, mid + 1, end);
        return false;
    }
}
