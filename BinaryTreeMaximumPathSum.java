import java.util.Stack;

class Solution {
    public int maxPathSum(TreeNode root) {
        Stack<Node> nodes = new Stack<Node>();
        Stack<Integer> sum = new Stack<Integer>();
        nodes.add(new Node(root, true));
        int max = Integer.MIN_VALUE;
        while (!nodes.empty()) {
            Node node = nodes.peek();
            if (node.isVisited) {
                nodes.pop();
                int lMax = 0;
                if (node.left != null) lMax = sum.pop();
                lMax = lMax > 0 ? lMax : 0;
                int rMax = 0;
                if (node.right != null) rMax = sum.pop();
                rMax = rMax > 0 ? rMax : 0;
                int temp = node.val + lMax + rMax;
                if (temp > max) max = temp;
                sum.push(node.val + Math.max(rMax, lMax));

            } else {
                node.isVisited = true;
                if (node.left != null) nodes.push(new Node(node.left, true));
                if (node.right != null) nodes.push(new Node(node.right, false));
            }
        }
        return max;
    }

    class Node {
        int val;
        TreeNode left;
        TreeNode right;
        boolean isVisited;
        boolean isLeft;

        public Node(TreeNode node, boolean isLeft) {
            this.val = node.val;
            this.left = node.left;
            this.right = node.right;
            isVisited = false;
            this.isLeft = isLeft;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}