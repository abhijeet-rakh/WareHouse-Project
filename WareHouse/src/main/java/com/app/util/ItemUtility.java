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
public class ItemUtility {

	public void generatePieChart(String path, List<Object[]> list) {

		// Convert list Object array into DataSet
		DefaultPieDataset dpiedataset = new DefaultPieDataset();

		for (Object[] d : list) {
			dpiedataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}

		// convert dataset to JFreeChart by using ChartFactory
		JFreeChart jfc = ChartFactory.createPieChart3D("Item Pie", dpiedataset, true, true, false);

		// Convert JFreeChart into image by using ChartUtilities
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/ItemPie.jpg"), jfc, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void generateBarChart(String path, List<Object[]> list) {

		// 1.Create Object of DefaultCategoryDataset
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();

		for (Object[] d : list) {
			bardataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}

		// 2. Convert dataset to Jfreechart
		JFreeChart jfchart = ChartFactory.createBarChart("Item BAR", "Uom Model", "Count", bardataset,
				PlotOrientation.HORIZONTAL, true, true, false);

		// 3.Convert JfreeChart to image
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/ItemBarChart.jpg"), jfchart, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
