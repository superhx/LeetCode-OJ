class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1, cur2 = n - 1;
        int i;
        for (i = m + n - 1; i >= 0; i--) {
            if (cur1 < 0 || cur2 < 0) break;
            nums1[i] = nums1[cur1] > nums2[cur2] ? nums1[cur1--] : nums2[cur2--];
        }
        for (; cur1 >= 0; cur1--, i--) nums1[i] = nums1[cur1];
        for (; cur2 >= 0; cur2--, i--) nums1[i] = nums2[cur2];
    }
}
