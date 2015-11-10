import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        List<List<Integer>> subsets = new LinkedList<>();
        for (Integer key : map.keySet()) {
            int occur = map.get(key);
            if (subsets.size() == 0) {
                for (int i = 0; i <= occur; i++) {
                    List<Integer> subset = new LinkedList<>();
                    for (int j = 0; j < i; j++) subset.add(key);
                    subsets.add(subset);
                }
            } else {
                List<List<Integer>> lists = new LinkedList<>();
                for (List<Integer> list : subsets) {
                    for (int i = 1; i <= occur; i++) {
                        List<Integer> subset = new LinkedList<>(list);
                        for (int j = 0; j < i; j++) subset.add(key);
                        lists.add(subset);
                    }
                }
                subsets.addAll(lists);
            }
        }
        return subsets;
    }
}
