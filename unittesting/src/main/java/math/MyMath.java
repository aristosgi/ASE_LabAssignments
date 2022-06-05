package math;

public class MyMath {

    public int factorial(int n) {
        if (!(n < 0 || n > 12)) {
            if (n == 0)
                return 1;
            else
                return (n * factorial(n - 1));

        } else

        {
            throw new IllegalArgumentException("Number should be between 0 and 12");
        }

    }

    public boolean isPrime(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Number should ne >2");
        } else {
            boolean flag = true;
            for (int i = 2; i <= n / 2; ++i) {
                // condition for nonprime number
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    }

}
