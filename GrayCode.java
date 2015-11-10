import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        LinkedList<Integer> codes = new LinkedList<>();
        codes.add(0);
        for (int i = 1; i < (1 << n); i++) {
            codes.add(codes.getLast() ^ (i & (-i)));
        }
        return codes;
    }
}
