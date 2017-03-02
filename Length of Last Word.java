public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int cur = s.length() - 1;
        while(cur >= 0 && s.charAt(cur) == ' ') cur--;
        int len = 0;
        while(cur >= 0 && s.charAt(cur--) != ' ') len++;
        return len;
    }
}
