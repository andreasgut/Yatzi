package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.LocalDate;

public class AktuellesDatum {


    static LocalDate formatDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter df;
        System.out.println(date);      // 2016-01-31 
        //df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);      // Sonntag, 31. Januar 2016
        //df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);      // 31. Januar 2016
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);    // 31.01.2016 
        //df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);     // 31.01.16
        System.out.println(date.format(df));

        return date;

    }


} 