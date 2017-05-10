package cleancode;

public class PlusOpNode extends OpNode {

	@Override
	public int execute() {
		// TODO Auto-generated method stub
		return this.left.execute() + this.right.execute();
	}

}
