package math;
import io.FileIO;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {
    ArrayOperations ao = new ArrayOperations();


    @Test
    public void testPrimeNumbers() {
        String resource = "src/test/resources/test_mock.txt";
        MyMath m = mock(MyMath.class);
        FileIO file = mock(FileIO.class);
        when(m.isPrime(2)).thenReturn(true);
        when(m.isPrime(3)).thenReturn(true);
        when(m.isPrime(8)).thenReturn(false);
        when(file.readFile(resource)).thenReturn(new int[]{2,3,8});
        Assert.assertArrayEquals(new int[]{2,3} , ao.findPrimesInFile(file,resource , m));
        
    }
}
