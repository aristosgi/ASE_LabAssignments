package grades;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 *
 * @author aristosgi The purpose of this class is to demonstrate a simple
 *         scenario of a representing a list of grades from 1-10 to a chart with
 *         frequencies.
 * @since April 2022
 *
 */

public class HistogramGenerator {

    /***
     * Receives a single dimension Integer array. From this array the dataset
     * that will be used for the visualization is generated. Finally, The chart
     * is generated with the use of the aforementioned dataset and then
     * presented in the screen.
     *
     * @param dataValues Single dimension integer array
     */

    public void chartGenerator(int[] dataValues) {
        /*
         * The XYSeriesCollection object is a set XYSeries series (dataset) that
         * can be visualized in the same chart
         */
        XYSeriesCollection dataset = new XYSeriesCollection();
        /*
         * The XYSeries that are loaded in the dataset. There might be many
         * series in one dataset.
         */
        XYSeries data = new XYSeries("random values");

        /*
         * Populating the XYSeries data object from the input Integer array
         * values.
         */
        for (int i = 0; i < dataValues.length; i++) {
            data.add(i, dataValues[i]);
        }

        // add the series to the dataset
        dataset.addSeries(data);

        boolean legend = false; // do not visualize a legend
        boolean tooltips = false; // do not visualize tooltips
        boolean urls = false; // do not visualize urls

        // Declare and initialize a createXYLineChart JFreeChart
        JFreeChart chart = ChartFactory.createXYLineChart("Grades Frequency", "Grades", "Frequency", dataset,
                PlotOrientation.VERTICAL, legend, tooltips, urls);

        /*
         * Initialize a frame for visualizing the chart and attach the
         * previously created chart.
         */
        ChartFrame frame = new ChartFrame("Grades Chart", chart);
        frame.pack();
        // makes the previously created frame visible
        frame.setVisible(true);
    }

    /*
     * Convert the arraylist with the grades to a table
     * with the frequency of every grade
     * 
     * @param  @param data Single dimension integer array with the frequency of each grade
     */

    public void convertGrades(ArrayList<Integer> grades) {

        int[] data = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        // match every grade to the data table
        for (int i = 0; i < grades.size(); i++) { // for every grade
            int place = grades.get(i); // the place of the grade
            data[place] = data[place] + 1; // add to the frequency table
        }
        // create HistogramGenerator object
        HistogramGenerator demo = new HistogramGenerator();
        // call the generator
        demo.chartGenerator(data);
    }

        /*
         * main method which reads the txt file
         * and create an array list with the values
         * @param dataValues arraylist with integers
         * @param path the path of the txt file
         * @param grades the txt file
         */

    public static void main(String[] args) throws FileNotFoundException {
        

        // read the input values
        ArrayList<Integer> dataValues = new ArrayList<>();
        // try to open the txt file
        

        try {
            String path = args[0];
            File grades = new File(path);
            // open the Scanner
            Scanner sc = new Scanner(grades);
            while (sc.hasNext()) {
                // add every grade to the arraylist
                dataValues.add(sc.nextInt());
            }
            // create HistogramGenerator object
            HistogramGenerator demo = new HistogramGenerator();
            demo.convertGrades(dataValues);
            // close the scanner
            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}