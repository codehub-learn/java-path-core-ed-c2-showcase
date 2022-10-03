package gr.codelearn.core.showcase.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AssertionDemoTest {
	@Test
	void example1() {
		fail("This test will fail");
	}
	
	@Test
	void example2() {
		int expected = 1;
		int actual = 2;
		assertEquals(expected,actual);
	}

}
