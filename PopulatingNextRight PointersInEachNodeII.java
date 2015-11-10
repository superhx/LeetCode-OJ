import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode levelFirstNode = root, currentParent;
        Queue<TreeLinkNode> adjacency = new LinkedList<TreeLinkNode>();
        while (levelFirstNode != null) {
            currentParent = levelFirstNode;
            adjacency.clear();
            while (currentParent != null) {
                while (currentParent != null) {
                    if (currentParent.left != null) {
                        adjacency.offer(currentParent.left);
                        if (adjacency.size() == 2) adjacency.poll().next = adjacency.peek();
                    }
                    if (currentParent.right != null) {
                        adjacency.add(currentParent.right);
                        if (adjacency.size() == 2) adjacency.poll().next = adjacency.peek();
                    }
                    currentParent = currentParent.next;
                }
            }
            while (levelFirstNode != null) {
                if (levelFirstNode.left != null) {
                    levelFirstNode = levelFirstNode.left;
                    break;
                }
                if (levelFirstNode.right != null) {
                    levelFirstNode = levelFirstNode.right;
                    break;
                }
                levelFirstNode = levelFirstNode.next;
            }
        }

    }
}
