package algorithms;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramsTest {
    Anagrams cut = new Anagrams();
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
	List<String> list = cut.anagrams(new String[]{"tea","and","ate","eat","den"});
	assertThat(list, isA(List.class));
    }

    @Test
    public void testEmtpyStrings() {
	List<String> list = cut.anagrams(new String[]{"",""});
	assertThat(list, isA(List.class));
    }
    
    @Test
    public void testMultiAnagrams(){
	List<String> list = cut.anagrams(new String[]{"tea","","eat","","tea",""});
	assertThat(list, isA(List.class));
	org.junit.Assert.assertEquals("more anagrams", list.size(),6);
    }

}
