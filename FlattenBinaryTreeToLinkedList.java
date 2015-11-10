import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.empty()) {
            node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) {
                stack.push(node.left);
                node.right = node.left;
                node.left = null;
            } else if (node.right == null) {
                node.right = stack.empty() ? null : stack.peek();
            }
        }
    }
}
