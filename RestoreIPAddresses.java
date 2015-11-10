import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<String> l = new Solution().restoreIpAddresses("010010");
        //System.out.print("2333".substring(0, 4));
        System.out.println(Integer.parseInt("010"));
    }

    public List<String> restoreIpAddresses(String s) {
        return restore(s, 4);
    }

    private List<String> restore(String s, int remains) {
        List<String> res = new LinkedList<>();
        if (remains == 1) {
            if (isLegal(s)) res.add(s);
            return res;
        }
        remains--;
        for (int i = 1, len = s.length(); i <= 3 && i < len; i++) {
            String prefix = s.substring(0, i);
            if (!isLegal(prefix)) break;
            for (String post : restore(s.substring(i, len), remains)) {
                res.add(prefix + "." + post);
            }
        }
        return res;
    }

    private boolean isLegal(String str) {
        int len = str.length();
        if (len == 0 || len > 3) return false;
        if (str.charAt(0) == '0' && len != 1) return false;
        if (Integer.parseInt(str) > 255) return false;
        return true;
    }
}
