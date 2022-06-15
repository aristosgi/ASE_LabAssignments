package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * This class deliberately contains code smells and violations of design principles. 
 * @author agkortzis
 *
 */
public class MetricsExporter {
	
	public void writeFile(String outputType, Map<String, Integer> metrics, String filepath) {
		if (outputType.equals("csv")) {
			writeCsv(metrics, filepath);
		} else if (outputType.equals("json")) {
			writeJson(metrics, filepath);
		} else {
			throw new IllegalArgumentException("Unknown type : " + outputType);
		}
	}
	

}
