import java.util.Collections;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Collections.reverse(triangle);
        // plus 2 for first line
        int[] sums = new int[triangle.size() + 2];
        for (List<Integer> line : triangle) {
            int index = 0;
            for (Integer node : line) {
                sums[index] = Math.min(sums[index] + node, sums[++index] + node);
            }

        }
        return sums[0];
    }
}
