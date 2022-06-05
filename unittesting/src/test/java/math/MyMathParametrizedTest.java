package math;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyMathParametrizedTest {

    MyMath mm = new MyMath();
    
    @Parameter (value = 0)
    public int fact ;

    @Parameter (value = 1)
    public int result ;

    @Parameters
    public static Collection <Object[]> data(){
        Object[][] data = new Object[][]{{0,1} , {1,1} , {2,2} , {3,6} , {12 , 479001600}};

        return Arrays.asList(data);
    }

    @Test
    public void testFactorial(){
        Assert.assertEquals(result , mm.factorial(fact));
    }
    

}
