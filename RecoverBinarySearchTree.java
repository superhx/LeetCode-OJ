class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
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
