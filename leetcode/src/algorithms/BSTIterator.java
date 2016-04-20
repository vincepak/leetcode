package algorithms;

import java.util.Stack;

/**
 * Definition of TreeNode:
  public class TreeNode {
      public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 *
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
	
    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
	pushNode(root);
    }

    private void pushNode(TreeNode root) {
	TreeNode node = root;
	while(node !=null){
	    stack.push(node);
	    node = node.left;
	}
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
	return !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
	TreeNode ret = stack.pop();
//	ret has no left node
	if (ret.right !=null) {
	    pushNode(ret.right);
	}
	return ret;
    }
}