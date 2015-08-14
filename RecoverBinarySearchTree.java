package leetcode;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {


    public void recoverTree(TreeNode root) {
        new Restoration().recoverTree(root);
    }

    class Restoration {
        TreeNode lastError;
        TreeNode lastErrorNext;
        TreeNode prev;
        boolean isTwoError = false;

        public void recoverTree(TreeNode root) {
            ldr(root);
            if (!isTwoError && lastError != null) {
                swap(lastError, lastErrorNext);
            }
        }

        private void ldr(TreeNode node) {
            if (node == null) return;
            ldr(node.left);
            if (prev != null && prev.val > node.val) {
                if (lastError == null) {
                    lastError = prev;
                    lastErrorNext = node;
                } else {
                    swap(node, lastError);
                    isTwoError = true;
                    return;
                }
            }
            prev = node;
            ldr(node.right);
        }

        private void swap(TreeNode first, TreeNode second) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
// origin 1 2 3 4 5 6
// 1 5 3 4 2 6
// 1 3 2 4 5 6

//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(6);
//        node1.left = node2;
//        node2.left = node3;
//        node1.right = node4;
//        node4.left = node5;
//        node4.right = node6;
//        new Solution().recoverTree(node1);
//        new Solution().recoverTree(node1);
//    }