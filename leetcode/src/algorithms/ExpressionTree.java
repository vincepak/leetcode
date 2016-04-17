package algorithms;

import java.util.Stack;

/**
 * Example
For the expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
The expression tree will be like

                 [ - ]
             /          \
        [ * ]              [ / ]
      /     \           /         \
    [ 2 ]  [ 6 ]      [ + ]        [ + ]
                     /    \       /      \
                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
After building the tree, you just need to return root node [-].
 * Definition of ExpressionTreeNode:
 * 
 */
class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left, right;

    public ExpressionTreeNode(String symbol) {
	this.symbol = symbol;
	this.left = this.right = null;
    }
    
    public String toString(){
	return breadFirstSearch(this);
    }
    public static String breadFirstSearch(ExpressionTreeNode root){
	StringBuilder sb = new StringBuilder();
	sb.append("{");
	ExpressionTreeNode node = null;
	Stack<ExpressionTreeNode> stack = new Stack<ExpressionTreeNode>();
	stack.push(root);
	sb.append(root.symbol);
	while(!stack.empty()){
	     node = stack.pop();
	     if(node.hasChildren()){
		 appendNode(sb, stack, node.left);
		 appendNode(sb, stack, node.right);
	     }
	}
	sb.append("}");
	return sb.toString();
    }

    private static void appendNode(StringBuilder sb, Stack<ExpressionTreeNode> stack, ExpressionTreeNode node) {
	if(node == null){
	    sb.append(",#");
	} else{
	    sb.append(","+node.symbol);
	    stack.push(node);
	}
	
    }

    private boolean hasChildren() {
	return this.left!= null || this.right!=null;
    }
}

public class ExpressionTree {
    // public class Solution {
    static String [] calcSymbols = {"+","-","*","/"};
    Stack<ExpressionTreeNode> nodes = new Stack<ExpressionTreeNode>();
    Stack<String> operators = new Stack<String>();
    /**
     * @param expression:
     *            A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {

	for(String exp:expression){
	    if(exp.trim().equals("(")){ 
		//
		operators.push(exp);
	    } else if(exp.equals(")")){
		while(!operators.peek().equals("(")){
    		//right bracket, merge node. until reaches left bracket
    		ExpressionTreeNode root = new ExpressionTreeNode(operators.pop());
    		root.right = nodes.pop();
    		root.left = nodes.pop();
    		nodes.push(root);
		}
		operators.pop();//pop the left bracket
	    } else if(isOperator(exp)){
		//do the operator
		//if exp = lowPrio, merge node until empty or left bracket
		//if exp = high prior, & pre = high prior, merge node
		if(!isHighPrioOperator(exp)){
		    while(!operators.isEmpty() && !operators.peek().equals("(")){
			ExpressionTreeNode root = new ExpressionTreeNode(operators.pop());
			root.right = nodes.pop();
			root.left = nodes.pop();
			nodes.push(root);
		    }
	    	} else {
	    	    if(!operators.isEmpty() && isHighPrioOperator(operators.peek())){
	    		ExpressionTreeNode root = new ExpressionTreeNode(operators.pop());
			root.right = nodes.pop();
			root.left = nodes.pop();
			nodes.push(root);
	    	    }
	    	}
		//push me
		operators.push(exp);
	    } else { //! (, ), +-*/
		//is number
		nodes.push(new ExpressionTreeNode(exp));
	    }
	}
	
	
	//after reading input
	while(!operators.isEmpty()){
	    ExpressionTreeNode root = new ExpressionTreeNode(operators.pop());
        		root.right = nodes.pop();
        		root.left = nodes.pop();
        		nodes.push(root);
	}
	
	if(nodes.isEmpty()){
	    return null;
	}
	return nodes.pop();
	
    }
    
    private boolean isHighPrioOperator(String string) {	
	return string.equals("*") || string.equals("/");
    }

    private boolean isOperator(String input){
	for(String calc:calcSymbols){
	    if(calc.equals(input)) return true;
	}
	return false;
    }
}