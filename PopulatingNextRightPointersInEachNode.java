package leetcode;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelFirstNode = root, currentParent;
        while (levelFirstNode != null) {
            currentParent = levelFirstNode;
            levelFirstNode = levelFirstNode.left;
            if (currentParent.left == null) continue;
            while (true) {
                currentParent.left.next = currentParent.right;
                if (currentParent.next == null) break;
                currentParent.right.next = currentParent.next.left;
                currentParent = currentParent.next;
            }
        }
    }
}