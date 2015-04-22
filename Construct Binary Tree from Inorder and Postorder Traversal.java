package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,postorder,0,inorder.length);
    }

    private TreeNode buildTree(int[] inorder,int istart, int[] postorder,int pstart,int length){
        if(length<=0) return null;

        int rootVal=postorder[pstart+length-1];
        TreeNode root=new TreeNode(rootVal);

        int leftLength=0,rightLength=0,iroot=0;
        for(int i=istart;i<istart+length;i++){
            if(rootVal==inorder[i]){
                leftLength=i-istart;
                rightLength=length-leftLength-1;
                iroot=i;
                break;
            }
        }

        root.left=buildTree(inorder,istart,postorder,pstart,leftLength);
        root.right=buildTree(inorder,iroot+1,postorder,pstart+length-rightLength-1,rightLength);
        return root;
    }
}