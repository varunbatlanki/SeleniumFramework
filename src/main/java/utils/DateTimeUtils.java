package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtils {

	private DateTimeUtils() {
	}

	private static final DateTimeFormatter FORMATTER =

			DateTimeFormatter.ofPattern(

					"yyyyMMdd_HHmmss");

	public static String getTimeStamp() {

		return LocalDateTime.now()

				.format(FORMATTER);

	}

}