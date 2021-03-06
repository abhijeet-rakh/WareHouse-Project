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
public class UnitOfMeasurementtypeUtility {

	public void generatePieChart(String path, List<Object[]> list) {

		// Convert list Object array into DataSet
		DefaultPieDataset dpiedataset = new DefaultPieDataset();

		for (Object[] d : list) {
			dpiedataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}

		// convert dataset to JFreeChart by using ChartFactory
		JFreeChart jfc = ChartFactory.createPieChart3D("UnitOfMeasurement Type", dpiedataset, true, true, false);

		// Convert JFreeChart into image by using ChartUtilities
		try {
			ChartUtils.saveChartAsJPEG(new File(path + "resources/PieChart/UnitOfMeasurementTypePie.jpg"), jfc, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//generatePieChart
	
	public void generateBarChart(String path,List<Object[]> list) {
		
		//Convert List Object array into DefaultCategoryDataset
		DefaultCategoryDataset dcdataset=new DefaultCategoryDataset();
		
		for(Object[] dc:list) {
			dcdataset.setValue(new Double(dc[1].toString()),dc[0].toString(),"UnitOfMeasurement Type");
		}
		
		//Convert DefaultCategoryDataset into JFreeChart
		JFreeChart jfchart=ChartFactory.createBarChart("UnitOfMeasurement TYPE", "UnitOfMeasurement TYPE","COUNT",dcdataset,PlotOrientation.HORIZONTAL,true,true,false);
		
		//convert JFreeChart into image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/PieChart/UnitOfMeasurementTypeBar.jpg"), jfchart, 250,250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}