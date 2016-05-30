package algorithms;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommonSubstringTest {

    private CommonSubstring cut;

    @Before
    public void setUp() throws Exception {
	cut = new CommonSubstring();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testEmptyStr() {
	assertThat(cut.longestCommonSubstring("", ""), is(0));
	assertThat(cut.longestCommonSubstring(null, "ABC"), is(0));

    }

    @Test
    public void testEqualString() {
	// assertThat(cut.longestCommonSubstring("", ""),is(0));
	assertThat(cut.longestCommonSubstring("ABC", "ABC"), is(3));
    }

    @Test
    public void testIntersectlString() {
	assertThat(cut.longestCommonSubstring("A", "CA"), is(1));
	assertThat(cut.longestCommonSubstring("ABCD", "DBCA"), is(2));
    }

    @Test
    public void testIndexOutOfBound() {
	assertThat(cut.longestCommonSubstring("www.lintcode.com code", "www.ninechapter.com code"), is(9));
    }

    @Test
    public void testLong() {
	assertThat(cut.longestCommonSubstring(
		//"adfanadsnf;andvadsjfafjdlsfnaldjfi*odiasjfasdlnfasldgao;inadfjnals;dfjasdl;jfa;dsjfa;sdnfsd;afhwery894yra7f78asfas8fy43rhaisuey34hiuy^%(9afysdfhaksdhfsdkjfhsdhfakldhfsdkf*h",
		"adfanadsnf;andvadsjfafjdlsfnaldjfi*odiasjfasdlnfasldgao;inadfjnals;dfjasdl;jfa;dsjfa;sdnfsd;afhwery894yra7f78asfas8fy43rhaisuey34hiuy^%(9afysdfhaksdhfsdkjfhsdhfakldhfsdkf*h",
//		"sdnfsd",
		"dafdnf**"), is(3));
    }

}
