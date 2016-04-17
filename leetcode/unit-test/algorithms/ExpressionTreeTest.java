package algorithms;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ExpressionTreeTest {
    
    private ExpressionTree cut;

    @Before
    public void setUp() throws Exception {
	cut = new ExpressionTree();
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void simpleTest(){
	String[] exp = {"1","+","2"};
	ExpressionTreeNode tree = cut.build(exp);
	assertThat(tree.symbol, is("+"));
	assertThat(tree.left.symbol, is("1"));
	assertThat(tree.right.symbol, is("2"));
    }
    
    @Test
    public void simple2Test(){
	/*
	 * 1+2+3
	 * 
	 * 	+
	 *   +	  3
	 * 1  2
	 */
	String[] exp = {"1","+","2", "+", "3"};
	ExpressionTreeNode tree = cut.build(exp);
	assertThat(tree.symbol, is("+"));
	assertThat(tree.left.symbol, is("+"));
	assertThat(tree.right.symbol, is("3"));
    }
    
    @Test
    public void prioTest(){
	/*
	 * 1+2*3
	 * 
	 *  2*3 has more priority than +
	 *     +
	 *   /	 \
	 * 1      *
	 *       2 3
	 */
	String[] exp = {"1","+","2", "*", "3"};
	ExpressionTreeNode tree = cut.build(exp);
	assertThat(tree.symbol, is("+"));
	assertThat(tree.left.symbol, is("1"));
	assertThat(tree.right.symbol, is("*"));
    }
    
//    @Test
    public void simpleBracket(){
	/*
	 * 1+2*(3-4)
	 * 
	 * 	 *
	 *      / \
	 *   +	    -
	 *  / \     /\
	 * 1   2   3  4
	 */
	String[] exp = {"1","+","2", "*", "3"};
	ExpressionTreeNode tree = cut.build(exp);
	assertThat(tree.symbol, is("*"));
	assertThat(tree.left.symbol, is("+"));
	assertThat(tree.right.symbol, is("3"));
    }

    @Test
    public void test() {
//	fail("Not yet implemented");
	String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
	ExpressionTreeNode tree = cut.build(expression);
//	assertThattree.symbol 
	assertNotNull(tree);
	assertThat(tree.symbol, is("-"));
	assertThat(tree.left.symbol, is("*"));
	assertThat(tree.right.symbol, is("/"));
    }

}
