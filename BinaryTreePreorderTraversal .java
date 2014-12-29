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

public class BinaryTreePreorderTraversal  {
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(root==null)
			return list;
		TreeNode temp;
		stack.add(root);
		while(!stack.isEmpty()){
			temp=stack.pop();
			list.add(temp.val);
			if(temp.right!=null) stack.push(temp.right);
			if(temp.left!=null) stack.push(temp.left);
		}
		return list;
	}
}