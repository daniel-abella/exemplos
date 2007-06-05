package simples;

import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Pizza {
	public static void main(String[] args) {
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("Norte", 13000000);
		ds.setValue("Nordeste", 48000000);
		ds.setValue("Centro-oeste", 11000000);
		ds.setValue("Sudeste", 73000000);
		ds.setValue("Sul", 25500000);
		
		JFreeChart grafico = ChartFactory.createPieChart("População nacional",
				ds, true, false, false);
		
		try {
			File png = new File("/tmp/pizza.png");
			ChartUtilities.saveChartAsPNG(png, grafico, 800, 500);
		} catch (Exception e) {}
	}
}
