package sourcecodeanalyzerrefactored.analyzer;

/**
 * This class is responsible for instantiating and returning 
 * a concrete type of SourceCodeAnalazyer
 * */


public class SourceCodeAnalyzerFactory {
    
    public class SourceCodeAnalyzerFactory {
	
        public SourceCodeAnalyzer createSourceCodeAnalyzer(String type) {
            if (type.equals("regex")) {
                return new RegexSourceCodeAnalyzer();
            } else if (type.equals("strcomp")) {
                return new StrCompSourceCodeAnalyzer();
            } else {
                return new NullSourceCodeAnalyzer();
            }
        }
    
    }
    
}
