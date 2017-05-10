package cleancode;

public class MultiOpNode extends OpNode {

	@Override
	public int execute() {
		return this.left.execute() * this.right.execute();
	}

}
