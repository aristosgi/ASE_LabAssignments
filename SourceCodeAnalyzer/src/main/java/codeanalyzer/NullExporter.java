package codeanalyzer;

import java.util.Map;

/**
 * This class defines the "Nothing" for any undefined type of MetricsExporter.

 *
 */
public class NullExporter implements MetricsExporter {

	@Override
	public void writeToFile(String filePath, Map<String, Integer> metrics) {
		throw new IllegalArgumentException("Unknown export type, process terminated");
	}

}
