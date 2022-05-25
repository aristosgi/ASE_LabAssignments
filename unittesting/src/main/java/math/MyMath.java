package math;

public class MyMath {

    public int factorial(int n) {
        if (n < 0 || n > 12) {
            if (n == 0)
                return 1;
            else
                return (n * factorial(n - 1));

        } else

        {
            throw new IllegalArgumentException("Number should be between 0 and 12");
        }

    }

}
