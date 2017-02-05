public class Solution {
   public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start >= end) return -1;
        if (start == end - 1) return target == nums[start] ? start: -1;

        if (nums[start] < nums[end - 1]) return binarySearch(nums, target, start, end);

        int mid = (start + end) / 2;
        int left = search(nums, target, start, mid );
        if (left != -1) return left;
        int right = search(nums, target, mid, end);
        if (right != -1) return right;
        return -1;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start >= end) return -1;
        int mid = (start + end) / 2;
        if (target == nums[mid]) return mid;
        if (target < nums[mid]) return binarySearch(nums, target, start, mid);
        if (target > nums[mid]) return binarySearch(nums, target, mid + 1, end);
        return -1;
    }
}
