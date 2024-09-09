package common.helpers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;


public class DateMaker {

    public String currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmssa");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getFormattedDate(LocalDateTime dateToFormat,String pattern) {
    	DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
    	dateTimeFormatterBuilder.appendPattern(pattern);
    	dateTimeFormatterBuilder.parseCaseInsensitive();
    	dateTimeFormatterBuilder.parseLenient();
    	dateTimeFormatterBuilder.parseDefaulting(ChronoField.YEAR, 2020);
    	dateTimeFormatterBuilder.parseDefaulting(ChronoField.MONTH_OF_YEAR, 1);
    	dateTimeFormatterBuilder.parseDefaulting(ChronoField.DAY_OF_MONTH, 1);
    	dateTimeFormatterBuilder.parseDefaulting(ChronoField.HOUR_OF_AMPM, 0);
    	dateTimeFormatterBuilder.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0);
    	dateTimeFormatterBuilder.parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0);
    	DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
    	return dateToFormat.format(dateTimeFormatter);
    }
    
    public LocalDateTime converToDateTime(String dateToConvert,String pattern) {
    	
    	DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
    	dateTimeFormatterBuilder.appendPattern(pattern);
    	dateTimeFormatterBuilder.parseCaseInsensitive();
    	dateTimeFormatterBuilder.parseLenient();
    	DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
    	return LocalDateTime.parse(dateToConvert, dateTimeFormatter);
    }
    
    public LocalDateTime converToDate(String dateToConvert,String pattern) {
    	
    	DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
    	dateTimeFormatterBuilder.appendPattern(pattern);
    	dateTimeFormatterBuilder.parseCaseInsensitive();
    	dateTimeFormatterBuilder.parseLenient();
    	DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
    	return LocalDate.parse(dateToConvert,dateTimeFormatter).atStartOfDay();
    }
}
