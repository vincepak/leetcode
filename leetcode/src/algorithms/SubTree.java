package algorithms;

import java.util.Stack;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */
class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
	this.val = val;
	this.left = this.right = null;
    }
}

public class SubTree {
    /**
     * @param T1,
     *            T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
	// write your code here
	/*
	 * since there are millions of nodes in T1, using recursion is not
	 * allowed
	 */

	if (T2 == null) {
	    return true;
	}
	if (T1 == null) {
	    return false;
	}
	Stack<TreeNode> stack1 = new Stack<TreeNode>();
	stack1.push(T1);
	TreeNode node = null;
	while (!stack1.isEmpty()) {
	    // look for Node == T2.root
	    node = stack1.pop();
	    if (node.val == T2.val) {
		if (isEqual(node, T2)) {
		    return true;
		}
	    }
	    if (node.left != null) {
		stack1.push(node.left);
	    }
	    if (node.right != null) {
		stack1.push(node.right);
	    }
	}
	return false;
    }

    private boolean isEqual(TreeNode t1, TreeNode t2) {
	// root t1 == t2;
	Stack<TreeNode> stack1 = new Stack<TreeNode>();
	Stack<TreeNode> stack2 = new Stack<TreeNode>();
	stack1.push(t1);
	stack2.push(t2);
	while (!stack2.isEmpty()) {
	    TreeNode node2 = stack2.pop();
	    TreeNode node1 = stack1.pop();

	    if (node2.left != null && node1.left == null) {
		return false;
	    } else if (node2.left == null && node1.left != null) {
		return false;
	    } else if (node2.left != null && node1.left != null) {
		if (node2.left.val != node1.left.val) {
		    return false;
		}

		stack2.push(node2.left);
		stack1.push(node1.left);
	    }

	    if (node2.right != null && node1.right == null) {
		return false;
	    } else if (node2.right == null & node1.right != null) {
		return false;
	    } else if (node2.right != null && node1.right != null) {

		if (node2.right.val != node1.right.val) {
		    return false;
		}

		stack2.push(node2.right);
		stack1.push(node1.right);
	    }

	}

	return true;
    }
}