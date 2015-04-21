package leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num,0,num.length-1);
    }

    public TreeNode sortedArrayToBST(int[] num,int start,int end){
        if(end<start) return null;
        int mid=(end-start)/2+start;
        TreeNode root=new TreeNode(num[mid]);
        root.left=sortedArrayToBST(num,start,mid-1);
        root.right=sortedArrayToBST(num,mid+1,end);
        return root;
    }

    public static void main(String[] args){
        new Solution().sortedArrayToBST(new int[]{});
    }
}