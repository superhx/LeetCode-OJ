public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c: t.toCharArray()) map[c]++;

        int end = 0, start = 0, count = t.length(), min = Integer.MAX_VALUE, head = 0;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - start < min) min = end - (head = start);
                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }
        return min == Integer.MAX_VALUE ? "": s.substring(head, head + min);
    }
}
