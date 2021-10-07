package br.com.ebix.escola.utils;

import java.sql.Date;
import java.util.Calendar;

public class ConverteDataUtil {
	public static Calendar converterDateParaCalendar(Date date) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(date);
		return calendario;
	}
	
	public static Date converterCalendarParaDate(Calendar calendar) {
		return new Date(calendar.getTimeInMillis());
	}
}
