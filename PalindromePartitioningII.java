import java.util.Arrays;

class PalindromePartitioningII {
    public int minCut(String s) {
        int length = s.length();
        if (length <= 1)
            return 0;

        // record whether the substring between start and end is palindrome.
        boolean[][] palindromes = new boolean[length][length];
        for (int i = 0; i < length; i++)
            Arrays.fill(palindromes[i], false);
        int[] cuts = new int[length];
        Arrays.fill(cuts, length);

        for (int start = length - 1; start >= 0; start--) {
            for (int end = start; end < length; end++) {
                if (s.charAt(start) == s.charAt(end))
                    if (end - start < 2)
                        palindromes[start][end] = true;
                    else
                        palindromes[start][end] = palindromes[start + 1][end - 1];

                //calculate the minimum cut from start to length-1
                if (palindromes[start][end])
                    cuts[start] = (end == length - 1) ? 0 : Math.min(
                            cuts[start], cuts[end + 1] + 1);
            }
        }
        return cuts[0];
    }
}
