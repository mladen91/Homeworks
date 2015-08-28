package ba.bitcamp.homework25.task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class only contains method that return time and date as String where
 * method uses DateFormat class
 * 
 * @author Mladen13
 *
 */
public class DateTime {

	public static String timeDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

}

