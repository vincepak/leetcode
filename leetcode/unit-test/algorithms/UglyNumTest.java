package algorithms;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UglyNumTest {

    private UglyNumber cut;

    @Before
    public void setUp() throws Exception {
	cut = new UglyNumber();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test8() {
	assertThat( cut.isUgly(8), is(true));
    }
    
    @Test
    public void test14() {
	assertThat( cut.isUgly(14), is(false));
    }

}
