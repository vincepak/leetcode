package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExcelColumnTitleTest {

	ExcelColumnTitle cut = new ExcelColumnTitle();

	@Test
	public void test0() {

		String a = cut.convertToTitle(1);
		assertEquals("1st colum is A ", a, "A");

		a = cut.convertToTitle(2);
		assertEquals(a, "B");

		a = cut.convertToTitle(3);
		assertEquals(a, "C");

		a = cut.convertToTitle(26);
		assertEquals(a, "Z");

	}

	@Test
	public void testDoubleDigits() {
		String a = cut.convertToTitle(27);
		assertEquals("AA", a);
	}
	
	@Test 
	public void test28(){
		String a = cut.convertToTitle(28);
		assertEquals("AB", a);
	}
	
	@Test
	public void test701(){
		String a = cut.convertToTitle(701);
		assertEquals("ZY", a);
		
	}
}
