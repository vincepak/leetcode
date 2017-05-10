package cleancode;

public class ValueNode extends Node {

	private int value;

	public ValueNode(int i) {
		this.value = i;
	}

	@Override
	public int execute() {
		return value;
	}

}
