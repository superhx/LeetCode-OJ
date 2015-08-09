package leetcode;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return max;
    }
}