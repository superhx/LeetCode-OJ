import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new LinkedList<>();
        if (num == null || num.length() == 0) return rst;
        helper(rst, num, "", target, 0, 0, 0);
        return rst;
    }

    private void helper(List<String> rst, String num, String path, int target, long eval, int pos, long multed) {
        if (pos == num.length() && target == eval) {
            rst.add(path);
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(rst, num, path + cur, target, cur, i + 1, cur);
            } else {
                helper(rst, num, path + "+" + cur, target, eval + cur, i + 1, cur);
                helper(rst, num, path + "-" + cur, target, eval - cur, i + 1, -cur);
                helper(rst, num, path + "*" + cur, target, eval - multed + multed * cur, i + 1,  multed * cur);
            }
            if (num.charAt(pos) == '0') break;
        }
    }
}
