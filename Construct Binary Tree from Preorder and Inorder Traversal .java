package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,inorder,0,preorder.length);
    }

    private TreeNode buildTree( int[] preorder,int pstart,int[] inorder,int istart,int length){
        if(length<=0) return null;

        int rootVal=preorder[pstart];
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

        root.left=buildTree(preorder,pstart+1,inorder,istart,leftLength);
        root.right=buildTree(preorder,pstart+1+leftLength,inorder,iroot+1,rightLength);
        return root;
    }

    public static void main(String[] args){
        TreeNode node=new Solution().buildTree(new int[]{1,2},new int[]{1,2});
    }
}