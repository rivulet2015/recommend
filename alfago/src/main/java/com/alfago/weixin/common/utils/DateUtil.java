package com.alfago.weixin.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String formatMoel = "yyyy-MM-dd HH:mm";
	private static final SimpleDateFormat format =new SimpleDateFormat(formatMoel);
	
	public static String toString(Date date){
		return format.format(date);
		
	}
}
