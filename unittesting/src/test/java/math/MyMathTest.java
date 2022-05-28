package math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
    /*
     * A test case for the exceptions caused when
     * first positive second negative. Testing
     * the exception is performed with a @Rule
     */

    MyMath mm = new MyMath();
    @Rule
    public ExpectedException thrown = ExpectedException.none(); // initialize it to .none()

    @Test
    public void testAddShouldThrowExceptionOnNegativeInput() {
        // With @Rules you can perform more sophisticated checks
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Number should be between 0 and 12");

        mm.factorial(-20);
    }
    @Rule
    public ExpectedException thrown1 = ExpectedException.none(); // initialize it to .none()

    @Test
    public void testAddShouldThrowExceptionOnPositiveInput() {
        // With @Rules you can perform more sophisticated checks
        thrown1.expect(IllegalArgumentException.class);
		thrown1.expectMessage("Number should be between 0 and 12");
        mm.factorial(20);
    }

}
