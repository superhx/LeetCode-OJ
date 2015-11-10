import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new LinkedList<>();
        inorderTraversal(root, traversal);
        return traversal;
    }

    private void inorderTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) return;
        inorderTraversal(node.left, traversal);
        traversal.add(node.val);
        inorderTraversal(node.right, traversal);
    }
}
