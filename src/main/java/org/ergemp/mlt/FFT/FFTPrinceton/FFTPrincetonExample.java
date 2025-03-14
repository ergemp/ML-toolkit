package org.ergemp.mlt.FFT.FFTPrinceton;

import org.ergemp.mlt.FFT.FFTPrinceton.model.Complex;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

import static org.ergemp.mlt.FFT.FFTPrinceton.function.FFT.fft;
import static org.ergemp.mlt.FFT.FFTPrinceton.function.FFT.show;


public class FFTPrincetonExample {
    public static void main(String[] args) {
        List<Double> inArr = Arrays.asList(509.630351,864.521388,754.576625,801.593761,769.054899,797.246815,772.433370,795.847463,772.169613,763.925403,795.019333,766.236530,773.456888,784.974405,782.503696,766.196897);
        int n = inArr.size();

        Complex[] x = new Complex[n];

        for (int i = 0; i < inArr.size(); i++) {
            x[i] = new Complex(inArr.get(i), 0);
        }

        show(x, "x");

        // FFT of original data
        Complex[] y = fft(x);
        show(y, "y = fft(x)");

        //
        //
        //

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultCategoryDataset barDataSet = new DefaultCategoryDataset();


        Integer cnt = 0;

        for (Integer i=0; i<x.length; i++) {
            //dataset.addValue((Double)x[i].getRe(),"x",cnt.toString());
            //dataset.addValue((Double)y[i].getRe(), "y", cnt.toString()) ;

            dataset.addValue((Double)x[i].getRe(),"X Real",i.toString());
            dataset.addValue((Double)y[i].getIm(), "FFT Image", i.toString()) ;
            barDataSet.addValue((Double)y[i].getIm(), "FFT Image", i.toString()) ;
        }

        //
        // combined chart
        //

        CategoryPlot plot = new CategoryPlot();
        plot.setDataset(0, dataset);
        plot.setRenderer(0, new LineAndShapeRenderer());

        plot.setDataset(1, barDataSet);
        plot.setRenderer(1, new BarRenderer());

        plot.setDomainAxis(new CategoryAxis("Sample"));
        plot.setRangeAxis(new NumberAxis("Value"));

        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);

        JFreeChart combinedChart = new JFreeChart(
                "",
                null,  // null means to use default font
                plot,  // combination chart as CategoryPlot
                true); // legend

        ChartPanel combinedChartPanel = new ChartPanel(combinedChart);
        JFrame frame2 = new JFrame();
        frame2.setSize(800, 600);
        frame2.setContentPane(combinedChartPanel);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        //
        //





        /*
        JFreeChart lineChart = ChartFactory.createLineChart(
                "FFT",
                "Sample",
                "Value",
                dataset);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setContentPane(chartPanel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        */

    }
}
