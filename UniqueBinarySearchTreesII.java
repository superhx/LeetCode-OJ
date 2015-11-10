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

    List<TreeNode>[][] nodesMatrix;

    public List<TreeNode> generateTrees(int n) {
        nodesMatrix = new List[n + 1][n + 1];
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> nodes = new LinkedList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        if (nodesMatrix[start][end] != null) return nodesMatrix[start][end];
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    nodes.add(root);
                }
            }
        }
        nodesMatrix[start][end] = nodes;
        return nodes;
    }
}
