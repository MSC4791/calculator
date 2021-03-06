package mschoi.calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
	CalculatorTest.java
*/
public class CalculatorTest {
	private Calculator calculator = new Calculator();

	@Test
	public void testSum() {
		assertEquals(5, calculator.sum(2, 3));
	}

	@Test
	public void testSub() {
		assertEquals(-2, calculator.sub(3, 5));
	}

	@Test
	public void testMul() {
		assertEquals(15, calculator.mul(5, 3));
	}

	@Test
	public void testDiv() {
		assertEquals(3, calculator.div(15, 5));
	}
}
