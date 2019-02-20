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
public class SaleOrderUtility {

	public void generatePieChart(String path, List<Object[]> list) {

		// Convert list Object array into DataSet
		DefaultPieDataset dpiedataset = new DefaultPieDataset();

		for (Object[] d : list) {
			dpiedataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}

		// convert dataset to JFreeChart by using ChartFactory
		JFreeChart jfc = ChartFactory.createPieChart3D("Sale Order Pie Chart", dpiedataset, true, true, false);

		// Convert JFreeChart into image by using ChartUtilities
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/SaleOrderPieChart.jpg"), jfc, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// generatePieChart

	public void generateBarChart(String path, List<Object[]> list) {

		// 1.Create Object of DefaultCategoryDataset
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();

		for (Object[] bd : list) {
			bardataset.setValue(new Double(bd[1].toString()), bd[0].toString(), "Shipment Type Bar Chart");
		}

		// 2.Convert dataset to JfreeChart Using ChartFactory
		JFreeChart barchart = ChartFactory.createBarChart("Sale Order Bar Chart", "Shipment Type", "Count",
				bardataset, PlotOrientation.HORIZONTAL, true, true, false);

		// 3.Convert JFreeChart to image
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/SaleOrderBarChart.jpg"), barchart, 250,
					250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// generateBarChart

}
