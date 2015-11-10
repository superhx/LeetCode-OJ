import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> paths = new LinkedList<>();
        pathSum(root, sum, path, paths);
        return paths;
    }

    private void pathSum(TreeNode root, int sum, Stack<Integer> path, List<List<Integer>> paths) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) paths.add(new LinkedList<>(path));
        } else {
            pathSum(root.left, sum - root.val, path, paths);
            pathSum(root.right, sum - root.val, path, paths);
        }
        path.pop();
    }
}
