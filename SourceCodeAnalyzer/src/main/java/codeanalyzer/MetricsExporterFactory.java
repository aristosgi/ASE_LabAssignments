package codeanalyzer;

/**
 * Implemantation of factory pattern for MetricsExporter class
 * to commpleted the strategy pattern.
 */
public class MetricsExporterFactory {
	
	/**
	 * Creates a MetricsExporter, according to the type of the output file. 
	 * @param filepath the path of the file
	 * @throws IllegalArgumentException
	 */
	public MetricsExporter createMetricsExporter(String fileType) {

		MetricsExporter exp;

		if (fileType.equals("csv")) {
			exp = new CSVExporter();
		} else if (fileType.equals("json")) {
			exp = new JSONExporter();
		} else {
			exp = new NullExporter();
		}
		return exporter;
	}

}
