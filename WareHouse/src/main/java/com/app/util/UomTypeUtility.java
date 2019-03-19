package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomTypeUtility {

	public void generatePieChart(String path, List<Object[]> list) {

		// convert list Object into dataset
		DefaultPieDataset dpiedataset = new DefaultPieDataset();

		for (Object[] obj : list) {
			dpiedataset.setValue(obj[0].toString(), new Double(obj[1].toString()));
		}

		// convert dataset to JFreeChart by using chartFactory
		JFreeChart jfc = ChartFactory.createPieChart3D("UOM Pie Chart", dpiedataset, true, true, false);

		try {
			// create JFreechart into image by using chartutilities
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/UOMTypePieChart.jpg"), jfc, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// generatePieChart

	public void generateBarChart(String path, List<Object[]> list) {

		// convert list object to dataset
		DefaultCategoryDataset dcatedataset = new DefaultCategoryDataset();

		for (Object[] d : list) {
			dcatedataset.setValue(new Double(d[1].toString()), d[0].toString(), "UOM Bar Chart");
		}

		// create JFreechart into image
		JFreeChart jfchart = ChartFactory.createBarChart("UOM Type", "UOM Type", "count", dcatedataset,
				PlotOrientation.HORIZONTAL, true, true, false);

		// Convert JFreeChart into image Using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/UOMTypeBarChart.jpg"), jfchart, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// generateBarChart

}
