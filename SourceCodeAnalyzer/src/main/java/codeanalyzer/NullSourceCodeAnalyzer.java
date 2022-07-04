package codeanalyzer;

import java.io.IOException;

/**
 * This class defines the "Nothing" for any undefined type of SourceCodeAnalyzer.
 * 
 *
 */
public class NullAnalyzer extends SourceCodeAnalyzer {

	@Override
	public int calculateLOC(String filepath) throws IOException {
		throw new IllegalArgumentException("Unknown type of Analyzer, cannot calculate LOC");
	}

	@Override
	public int calculateNOM(String filepath) throws IOException {
		throw new IllegalArgumentException("Unknown type of Analyzer, cannot calculate NOM");
	}

	@Override
	public int calculateNOC(String filepath) throws IOException {
		throw new IllegalArgumentException("Unknown type of Analyzer, cannot calculate NOC");
	}

} {
    
}
