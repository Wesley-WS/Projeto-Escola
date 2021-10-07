package br.com.ebix.escola.utils;

import java.util.Calendar;

public class ConverteDataUtil {
	public static Calendar converterDateParaCalendar(java.sql.Date date) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(date);
		return calendario;
	}
	
	public static java.sql.Date converterCalendarParaDatesql(Calendar calendar) {
		return new java.sql.Date(calendar.getTimeInMillis());
	}
	
	public static java.util.Date converterCalendarParaDate(Calendar calendar) {
		return new java.util.Date(calendar.getTimeInMillis());
	}
}
