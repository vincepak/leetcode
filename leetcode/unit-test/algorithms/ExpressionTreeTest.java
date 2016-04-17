package algorithms;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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
	
	// input ["2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"]
//	fail("Not yet implemented");
	String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
	ExpressionTreeNode tree = cut.build(expression);
//	assertThattree.symbol 
	assertNotNull(tree);
	assertThat(tree.symbol, is("-"));
	assertThat(tree.left.symbol, is("*"));
	assertThat(tree.right.symbol, is("/"));
    }
    
    @Test
    public void someTest(){
//	["2","*","(", "6", "/", "5", ")"]
	String[] expression = {"2","*","(", "6", "/", "5", ")"};
	ExpressionTreeNode tree = cut.build(expression);
	assertNotNull(tree);
	assertThat(tree.symbol, is("*"));
	assertThat(tree.left.symbol, is("2"));
	
    }
    
    /**
     * Output
{[/],[999],[+],#,#,[/],[+],[3],[/],[1],[/],#,#,[3],[3],#,#,[9],[3]}
Expected
{[+],[/],[+],[/],[3],[1],[/],[/],[3],#,#,#,#,[9],[3],[999],[3]}
     */
    @Test
    public void testBracket999(){
//	["(","999","/","3","/","3","/","3",")","+","(","1","+","9","/","3",")"]
	String[] expression = {"(","999","/","3","/","3","/","3",")","+","(","1","+","9","/","3",")"};
	ExpressionTreeNode tree = cut.build(expression);
	assertNotNull(tree);
	assertThat(tree.symbol, is("+"));
	assertThat(tree.left.symbol, is("/"));
    }
    
    /**
     * See representation of a Binary Tree
["(","(","(","(","(",")",")",")",")",")"]
Expected
{}
     */
    @Test
    public void testBracketsOnly(){
	String [] expression = {"(","(","(","(","(",")",")",")",")",")"};
	ExpressionTreeNode tree = cut.build(expression);
	assertNull(tree);
//	assertThat(tree.symbol, is("+"));
//	assertThat(tree.left.symbol, is("/"));
    }
    

}
