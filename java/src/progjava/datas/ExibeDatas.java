package progjava.datas;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExibeDatas {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(1967, 7, 6);
		c.set(Calendar.HOUR, 3);
		c.set(Calendar.MINUTE, 10);
		c.set(Calendar.SECOND, 45);
		Date d = c.getTime();
		
		List<DateFormat> ldf = new ArrayList<DateFormat>();
		ldf.add(DateFormat.getDateInstance(DateFormat.FULL));

		String str = null;
		for (DateFormat df : ldf) {
			str = df.format(d);
			System.out.println(str);
		}
		
		Date d2 = null;
		try {
			d2 = ldf.get(0).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(ldf.get(0).format(d2));
	}
}
