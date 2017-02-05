public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new LinkedList<>();
        rst.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> add = new LinkedList<>();
            for (List<Integer> set: rst) {
                List<Integer> copy = new ArrayList<>(set);
                copy.add(nums[i]);
                add.add(copy);
            }
            rst.addAll(add);
        }
        return rst;
    }
}
