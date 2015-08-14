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

    public boolean isValidBST(TreeNode root) {
        return new ValidBST().isValidBST(root);
    }

    class ValidBST {
        TreeNode prev;

        public boolean isValidBST(TreeNode node) {
            if (node == null) return true;
            if (!isValidBST(node.left)) return false;
            if (prev != null && prev.val >= node.val) return false;
            prev = node;
            if (!isValidBST(node.right)) return false;
            return true;
        }

    }
}
