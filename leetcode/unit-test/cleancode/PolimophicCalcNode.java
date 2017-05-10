package cleancode;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolimophicCalcNode {
	
	Node cut;
	
	@Before
	public void setUp(){
		OpNode cut = new PlusOpNode();
		this.cut = cut;
		cut.setLeft(new ValueNode(1));
		OpNode right = new MultiOpNode();
		right.setLeft(new ValueNode(2));
		right.setRight(new ValueNode(3));
		cut.setRight(right);

	}

	@Test
	public void test() {
		assertThat(cut.execute(), is(7));
	}

}
