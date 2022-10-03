package gr.codelearn.core.showcase.testing;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

public class AssertionDemoTest {
	@Test
	void example1() {
		fail("This test will fail");
	}
	
	@Test
	void example2() {
		int expected = 1;
		int actual = 1;
		assertEquals(expected,actual);
	}
	
	@Test
	void example3() {
		int expected = 1;
		int actual = 2;
		assertEquals(expected,actual,"The two integer values were not equal!");
	}
	
	@Test
	void example4() {
		boolean[] expected = {true,false,true};
		boolean[] actual = {true,false,false};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void example5() {
		assertAll(
				"Hulk powers",
				()-> assertEquals("Green","Green"),
				()->assertEquals("Ultimate strength","Hummer")
		);
	}
	
	@Test
	void example6() {
		assertThrows(ArithmeticException.class,()->{int division = 1 /0;});
	}
	
	@Test
	@DisplayName("The follwoing test assumes that a value is greater than 5")
	void example7() {
		int numberOfSomething = 100;
		assumeTrue(numberOfSomething > 0);
		assertTrue(numberOfSomething > 5);
	}
	
	@Test
	@DisplayName("This test is disabled")
	@Disabled("Implement when a specific functionality is ready")
	void example8() {
		fail();
	}
	
	@Test
	@DisplayName("This test must not run on Windows 0S")
	@DisabledOnOs
	void example9() {
		Object kali = new Object();
		Object centos = new Object();
		
		assertSame(kali, centos);
	}

}
