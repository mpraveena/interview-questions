/**
 * Tests Money - Add, Subtract, Multiply, Divide, Compare operations 
 * and String formatting.  
 */
package uiowa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uiowa.Money;

public class MoneyTest extends Assert {
	private Money testMoney;
	
	@BeforeMethod
	public void setUp() {
		testMoney = new Money(4556.50);
	}
	
	@AfterMethod
	public void tearDown() {
		testMoney = null;
	}
	
	@Test
	public void testAddition() {
		Money toAdd = new Money(55.50);
		assertEquals(testMoney.add(toAdd).getAmount().doubleValue(), 4612.0);
	}
	
	@Test
	public void testSubtraction() {
		Money toSubtract = new Money(30.30);
		assertEquals(testMoney.subtract(toSubtract).getAmount().doubleValue(), 4526.20);
	} 
	
	@Test
	public void testMultiplication() {
		assertEquals(testMoney.multiply(10).getAmount().doubleValue(), 45565.0);
	}
	
	@Test
	public void testDivision() {
		Money[] dividedMonies = testMoney.divide(10);
		assertEquals(dividedMonies.length, 10);
		for(Money money : dividedMonies){
			assertEquals(money.getAmount().doubleValue(), 455.65);
		}
	}
		
	@Test
	public void testComparison() {
		assertEquals(testMoney.compareTo(new Money(4556.50)), 0);
	}
	
	@Test
	public void testStringFormatting() {
		assertEquals(testMoney.getFormatedAmount(), "$4,556.50");
	}
	
}