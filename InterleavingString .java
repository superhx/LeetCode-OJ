package leetcode;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        // flags[i] indicate whether s1[0:i-1] s2[0,j-1] interleave to s3[0:i+j-1]
        boolean[] flags = new boolean[len1 + 1];
        for (int j = 0; j <= len2; j++) {
            flags[0] = (j == 0) || (flags[0] && s2.charAt(j - 1) == s3.charAt(j - 1));
            for (int i = 1; i <= len1; i++) {
                // flag(s1[0:i-1],s2[0:j-1]) = (flag(s1[0:i - 1],s2[0:j-1]) && s1.charAt(i-1) == s3.charAt(i + j - 1)) ||
                // (flag(s1[0:i-1],s2[0:j - 2]) && s2.charAt(j-1) == s3.charAt(i + j - 1))
                flags[i] = (flags[i-1] && s1.charAt(i-1) == s3.charAt(i + j -1)) || (flags[i] && s2.charAt(j-1) == s3.charAt(i + j - 1));
            }
        }
        return flags[len1];
    }
}