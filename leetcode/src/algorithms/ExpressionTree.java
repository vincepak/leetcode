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
}

public class ExpressionTree {
    // public class Solution {
    static String [] calcSymbols = {"+","-","*","/"};
    /**
     * @param expression:
     *            A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
	// write your code here
	boolean leftBrackt = false;
	Stack<ExpressionTreeNode> nodes = new Stack<ExpressionTreeNode>();
	Stack<String> operators = new Stack<String>();
	for(String exp:expression){
	    if(exp =="("){ leftBrackt = true;
	    } else if(exp ==")"){
		//right bracket, merge node.
		ExpressionTreeNode root = new ExpressionTreeNode(operators.pop());
		root.right = nodes.pop();
		root.left = nodes.pop();
		nodes.push(root);
		//clear leftbracket flag
		leftBrackt = false;
	    } else if(isOperator(exp)){
		//do the operator
		if(!isHighPrioOperator(exp)){//low prio
		    //check whether pervious operator is high prio
		    if(!leftBrackt && !operators.isEmpty() ){ //&& isHighPrioOperator(operators.peek())){
			//merge node.
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