package algorithms;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
    Anagram cut = new Anagram();
    @Before
    public void setUp() throws Exception {
	
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
	assertThat(cut.anagram("ab", "ab"), is(true));
    }
    
    @Test
    public void test2() {
	assertThat(cut.anagram("aacc", "ccac"), is(false));
    }

}
