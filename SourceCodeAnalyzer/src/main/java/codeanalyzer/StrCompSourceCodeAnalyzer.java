package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * The current functionality supports two types of source code analysis,
 * strcomp (with the use of string comparison).
 * @author agithk
 *
 */

public class StrCompSourceCodeAnalyzer {
    public int calculateNOM(String filepath, String analyzerType) throws IOException {
		
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int methodCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
						|| line.contains("void") || line.contains("int") || line.contains("String"))
					&& line.contains("(") && line.contains(")") && line.contains("{") )
					methodCounter++;
			}
    
    public int calculateNOC(String filepath, String analyzerType) throws IOException {
    
            List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
            int classCounter = 0;
            for (String line : sourceCodeList) {
                line = line.strip(); //remove leading and trailing white spaces
                if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
                    classCounter++;
                }
            }

    public int calculateLOC(String filepath, String analyzerType) throws IOException {

            List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
            int nonCodeLinesCounter = 0;
            for (String line : sourceCodeList) {
                line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
                if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
                    nonCodeLinesCounter++;
            }
            int loc = sourceCodeList.size() - nonCodeLinesCounter;
            return loc; 

        }
    }
}
}
