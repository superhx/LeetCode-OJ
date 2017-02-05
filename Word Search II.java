public class Solution {
   public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new LinkedList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, rst);
            }
        }
        return rst;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode root, List<String> rst) {
        if (board[i][j] == '#') return;
        int loc = board[i][j] - 'a';
        TrieNode next = root.nexts[loc];
        if (next == null) return;

        if (next.word != null) {
            rst.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';

        if (i - 1 >= 0) dfs(board, i - 1, j, next, rst);
        if (i + 1 < board.length) dfs(board, i + 1, j, next, rst);
        if (j - 1 >= 0) dfs(board, i, j - 1, next, rst);
        if (j + 1 < board[0].length) dfs(board, i, j + 1, next, rst);

        board[i][j] = (char)('a' + loc);
    }

     private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode cur = root;
            for (char c: word.toCharArray()) {
                int loc = c - 'a';
                if (cur.nexts[loc] == null) cur.nexts[loc] = new TrieNode();
                cur = cur.nexts[loc];
            }
            cur.word = word;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] nexts = new TrieNode[26];
        String word;
    }
}
