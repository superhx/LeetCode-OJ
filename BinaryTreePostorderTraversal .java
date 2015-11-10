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

class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if (root == null)
            return list;
        Node temp;
        stack.add(new Node(root));
        while (!stack.isEmpty()) {
            temp = stack.peek();
            if (temp.tag) {
                stack.pop();
                list.add(temp.node.val);
            } else {
                if (temp.node.right != null) stack.add(new Node(temp.node.right));
                if (temp.node.left != null) stack.add(new Node(temp.node.left));
                temp.tag = true;
            }
        }
        return list;
    }

    class Node {
        boolean tag;
        TreeNode node;

        public Node(TreeNode node) {
            this.node = node;
            this.tag = false;
        }
    }
}
