package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * An class that provides test cases for the
 * math operations of the ArithmeticOperations
 * class, for demonstrating Unit Testing.
 * 
 * @author aristosgi (aristogithk@gmail.com)
 */

public class ArithmeticOperationsTest {
    ArithmeticOperations ao = new ArithmeticOperations();

    /*
     * A unit test that checks an invalid zero input
     * that causes an IllegalArgumentException
     */
    @Test(expected = ArithmeticException.class)
    public void testGetSignShouldCauseAnException() {
        ao.divide(5, 0);
    }

    /*
	 * A unit test that checks a valid positive input
	 */
    @Test
    public void testGetSignShouldReturnRegularOutputPositive() {
    	Assert.assertEquals(3 , ao.divide(3 , 1) , 0.001);
    }

    /*
	 * A unit test that checks a valid negative input
	 */
    @Test
    public void testGetSignShouldReturnRegularOutput() {
    	Assert.assertEquals(3 , ao.divide(3 , 1) , 0.001);
    }

    /*
	 * A unit test that checks a valid input zero
	 */
    @Test
    public void testGetSignShouldReturnNormalOutputNegativeNumerator() {
    	Assert.assertEquals(-3 , ao.divide(-3 , 1) , 0.001);
    }

    /*
	 * A unit test that checks a valid negative numerator and deminator input
	 */
    @Test
    public void testGetSignShouldReturnNormalOutputNegativeBothNumerator() {
    	Assert.assertEquals(3 , ao.divide(-3 , -1) , 0.001);
    }

    /*
	 * A test case for the exceptions caused when
	 * first positive second negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test 
	public void testAddShouldThrowExceptionOnPositiveInput() {
		// With @Rules you can perform more sophisticated checks
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(5, -1);
		
	}



}
