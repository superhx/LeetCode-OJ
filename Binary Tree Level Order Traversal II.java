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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;
        List<TreeNode> prev = new LinkedList<>();
        prev.add(root);
        while (!prev.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            List<TreeNode> next = new LinkedList<>();
            for (TreeNode node : prev) {
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            levels.addFirst(level);
            prev.clear();
            prev.addAll(next);
        }
        return levels;
    }
}
