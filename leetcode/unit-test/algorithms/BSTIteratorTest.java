package algorithms;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BSTIteratorTest {
    

    private BSTIterator cut;

    @Before
    public void setUp() throws Exception {
	
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     *  
   10
 /    \
1      11
 \       \
  6       12
  
  [1, 6, 10, 11, 12]
     */
    @Test
    public void test() {
	TreeNode root = new TreeNode(10);
	root.left = new TreeNode(1);
	root.left.right = new TreeNode(6);
	root.right = new TreeNode(11);
	root.right.right = new TreeNode(12);
	
	cut = new BSTIterator(root);	
	assertThat(cut.hasNext(), is(true));
	TreeNode preNode = cut.next();
	while(cut.hasNext()){
	    TreeNode node = cut.next();
	    assertTrue(node.val > preNode.val);
	}
    }

}
