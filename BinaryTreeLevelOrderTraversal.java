package leetcode;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;
        Queue<TreeNode> cur = new LinkedList<>(), nxt = new LinkedList<>();
        cur.add(root);
        List<Integer> level = new LinkedList<>();
        while (!cur.isEmpty()) {
            TreeNode node = cur.poll();
            level.add(node.val);
            if (node.left != null) nxt.add(node.left);
            if (node.right != null) nxt.add(node.right);

            if (!cur.isEmpty()) continue;

            cur.addAll(nxt);
            nxt = new LinkedList<>();
            levels.add(level);
            level = new LinkedList<>();
        }
        return levels;
    }
}