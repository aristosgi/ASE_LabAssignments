package codeanalyzer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SourceCodeAnalyzerFacade {
	
	private SourceFileReader readerFactory;
	private SourceCodeAnalyzerFactory analyzerFactory;
	private MetricsExporterFactory exporterFactory;
	
	public SourceCodeAnalyzerFacade() {
		readerFactory = new ContentReaderFactory();
		analyzerFactory = new SourceCodeAnalyzerFactory();
		exporterFactory = new MetricsExporterFactory();
	}

	public SourceCodeAnalyzerFacade(SourceFileReader readerFactory, SourceCodeAnalyzerFactory analyzerFactory,
			MetricsExporterFactory exporterFactory) {
		this.readerFactory = readerFactory;
		this.analyzerFactory = analyzerFactory;
		this.exporterFactory = exporterFactory;
	}

	public void performFileAnalysis(String filepath, String analysisType, String fileLocation, String outputFileName, String outputFileType) throws IOException {

		SourceCodeAnalyzer analyzer = analyzerFactory.createSourceCodeAnalyzer(analysisType);
		// inject the content reader into the analyzer
		analyzer.setContentReader(contentReader);
		
		// perform the analysis
		int loc = analyzer.calculateLOC(filepath);
		int nom = analyzer.calculateNOM(filepath);
		int noc = analyzer.calculateNOC(filepath);
		
		// store metrics in a HashMap
		Map<String,Integer> metrics = new HashMap<>();
		metrics.put("loc", loc);
		metrics.put("nom", nom);
		metrics.put("noc", noc);
		
		// ask the factory to create and return a concrete MetricsExporter
		MetricsExporter metricsExporter = exporterFactory.createMetricsExporter(outputFileType);
		
		// export metrics to a file
		metricsExporter.writeToFile(outputFileName, metrics);
	}
}
