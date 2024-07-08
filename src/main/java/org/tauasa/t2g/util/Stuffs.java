package org.tauasa.t2g.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility stuffs
*/
public interface Stuffs {

	/**
	 * Specifies the date/time format to be used when stringifying a timestamp
	*/
	public static final String TEE_TIME_FORMAT = "yyMMddHHmm";
	public static final DateTimeFormatter TEE_TIME_FORMATTER = DateTimeFormatter.ofPattern(TEE_TIME_FORMAT);

	/**
	 * Parses a tee time into a LocalDateTime using TEE_TIME_FORMAT
	*/
	public static LocalDateTime parseTeeTime(String ts){
		return LocalDateTime.parse(ts, TEE_TIME_FORMATTER);
	}

	/**
	 * Formats the specified tee time or returns null
	*/
	public static String formatTeeTime(LocalDateTime date){
		if(date==null){
			//date = LocalDateTime.now();//this is hokey
			return null;
		}
		return date.format(TEE_TIME_FORMATTER);
	}    

}
