public class Solution {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        if (height == 0) return word.equals("");
        int width = board[0].length;
        BitSet pass = new BitSet(height * width);

        char first = word.charAt(0);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] != first) continue;
                if (helper(board, i, j, word, 0, pass)) return true;
                pass.clear();
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int start, BitSet pass) {
        int height = board.length;
        int width = board[0].length;
        if (start == word.length()) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(start)) return false;
        int loc = i * width + j;
        if (pass.get(loc)) return false;

        pass.set(loc);

        start++;
        boolean rst = helper(board, i + 1, j, word, start, pass)
            || helper(board, i - 1, j, word, start, pass)
            || helper(board, i, j + 1, word, start, pass)
            || helper(board, i, j - 1, word, start, pass);

        pass.set(loc, false);
        return rst;
    }
}
