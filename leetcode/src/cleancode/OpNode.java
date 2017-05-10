package cleancode;

public abstract class OpNode extends Node {

	protected Node left;
	protected Node right;

	public void setLeft(ValueNode valueNode) {
		this.left = valueNode;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
