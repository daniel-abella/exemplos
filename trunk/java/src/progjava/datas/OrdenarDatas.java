package progjava.datas;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OrdenarDatas {
	public static void main(String[] args) {
		long corrente = new Date().getTime();
		List<Date> ld = new ArrayList<Date>();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt","BR"));
		for (int i = 0; i < 10; i++)
			ld.add(new Date(corrente + ((int)(Math.random() * 30)) * 24 * 60 * 60 * 1000));
		
		Collections.sort(ld);
		
		Calendar c = Calendar.getInstance();
		for (Date d : ld) {
			c.setTime(d);
			System.out.print(df.format(d));
			System.out.printf(" %s\n", c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? "(domingo)" : "");
		}
	}
}
