package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UOMtypeUtility {

	public void generate(String path, List<Object[]> list) {

		// Convert list Object array into DataSet
		DefaultPieDataset dpiedataset = new DefaultPieDataset();

		for (Object[] d : list) {
			dpiedataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}

		// convert dataset to JFreeChart by using ChartFactory
		JFreeChart jfc = ChartFactory.createPieChart3D("ShipmentType", dpiedataset, true, true, false);

		// Convert JFreeChart into image by using ChartUtilities
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "/resources/PieChart/UOMTypePie.jpg"), jfc, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}