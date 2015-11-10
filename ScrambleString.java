class Solution {

    Boolean[][][] scramble;

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        scramble = new Boolean[len][len][len];
        return this.isScramble(s1, 0, s2, 0);
    }

    private boolean isScramble(String s1, int start1, String s2, int start2) {
        int len = s1.length();
        if (len == 1) return s1.equals(s2);
        for (int i = 1; i < len; i++) {
            scramble[start1][start2][i] = scramble[start1][start2][i] == null ? this.isScramble(s1.substring(0, i), start1, s2.substring(0, i), start2) : scramble[start1][start2][i];
            if (scramble[start1][start2][i] && scramble[start1 + i][start2 + i][len - i] == null)
                scramble[start1 + i][start2 + i][len - i] = this.isScramble(s1.substring(i, len), start1 + i, s2.substring(i, len), start2 + i);
            if (scramble[start1][start2][i] && scramble[start1 + i][start2 + i][len - i]) return true;

            scramble[start1][start2 + len - i][i] = scramble[start1][start2 + len - i][i] == null ? this.isScramble(s1.substring(0, i), start1, s2.substring(len - i, len), start2 + len - i) : scramble[start1][start2 + len - i][i];
            if (scramble[start1][start2 + len - i][i] && scramble[start1 + i][start2][len - i] == null)
                scramble[start1 + i][start2][len - i] = this.isScramble(s1.substring(i, len), start1 + i, s2.substring(0, len - i), start2);
            if (scramble[start1][start2 + len - i][i] && scramble[start1 + i][start2][len - i]) return true;
        }
        return false;
    }
}
