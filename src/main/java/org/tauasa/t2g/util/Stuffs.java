package org.tauasa.t2g.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility stuffs go here
*/
public interface Stuffs {

	public static final String TEE_TIME_FORMAT = "yyMMddHHmm";
	public static final DateTimeFormatter TEE_TIME_FORMATTER = DateTimeFormatter.ofPattern(TEE_TIME_FORMAT);
	public static final String TEE_TIME_PRETTY_FORMAT = "MM/dd/yyyy HH:mm";
	public static final DateTimeFormatter TEE_TIME_PRETTY_FORMATTER = DateTimeFormatter.ofPattern(TEE_TIME_PRETTY_FORMAT);

	public static LocalDateTime parseTeeTime(String ts){
		return LocalDateTime.parse(ts, TEE_TIME_FORMATTER);
	}

	public static String formatTeeTime(LocalDateTime date){
		if(date==null){
			//date = LocalDateTime.now();//this is hokey
			return null;
		}
		return date.format(TEE_TIME_FORMATTER);
	}

	public static String prettyFormatTeeTime(LocalDateTime date){
		if(date==null){
			return null;
		}
		return date.format(TEE_TIME_PRETTY_FORMATTER);
	}


}
