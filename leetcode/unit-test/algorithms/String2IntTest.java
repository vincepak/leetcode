package algorithms;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class String2IntTest {
    String2IntegerII cut = new String2IntegerII();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
	assertThat(cut.atoi("123123123123123"), is(2147483647));
    }
    
    @Test
    public void testfloat1() {
	assertThat(cut.atoi("1.0"), is(1));
    }
    
    @Test
    public void testMixString(){
	assertThat(cut.atoi("    52lintcode   "), is(52));
	assertThat(cut.atoi(" 15+4"), is(15));
//	read the number, until reaches to non number 
    }
    
    @Test
    public void testk(){
	assertThat(cut.atoi("    k"), is(0));
    }
    
    @Test
    public void testPlusMinusis0(){
	
	assertThat(cut.atoi("   +-1111 "), is(0));
    }
    
   

}
