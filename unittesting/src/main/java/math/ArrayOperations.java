package math;

import java.util.ArrayList;

import io.FileIO;

public class ArrayOperations {

    public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] ints = fileIo.readFile(filepath);
        for (int i : ints) {
            if (myMath.isPrime(i)) {
                result.add(i);
            }

        }
        int[] res = new int[result.size()];
        int c = 0;
        for (int j : result) {
            res[c] = j;
            c = c + 1;

        }
        return res;
    }
}
