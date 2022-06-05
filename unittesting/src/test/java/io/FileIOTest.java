package io;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FileIOTest {
    FileIO fileio = new FileIO();
    public static String resource = "src/test/resources/";

    @Test
    public void testReadFileValid(){
        int[] ExpectedInt = new int[]{3,0,6};
        String valid = resource.concat("grades.txt");
        Assert.assertArrayEquals(ExpectedInt , fileio.readFile(valid)); 

    }
    @Rule 
    public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
    @Test
    public void testReadFileEmpty(){
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
        String valid = resource.concat("empty.txt");
        fileio.readFile(valid); 

    }


    @Test
    public void testReadFileNotExist(){
        thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
        String valid = resource.concat("NotExist.txt");
        fileio.readFile(valid); 

    }

    @Test
    public void testReadFileContainsInvalidEntries(){
        int[] ExpectedInt = new int[]{3,5};
        String valid = resource.concat("grades_mixed.txt");
        Assert.assertArrayEquals(ExpectedInt , fileio.readFile(valid)); 
    }
    
    
}
