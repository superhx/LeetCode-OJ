package Practice;


public class Solution {
	int total;
	public int sumNumbers(TreeNode root) {
		total=0;
		findLeaf(root,0);
		return total;
	}
	
	private void findLeaf(TreeNode node,int val){
		if(node==null) return;
		val=val*10+node.val;
		if(node.left==null&&node.right==null){
			total+=val;
			return;
		}
		findLeaf(node.left,val);
		findLeaf(node.right,val);
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