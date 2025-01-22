package edu.wgu.d387_sample_code.convertor;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    public static String convertPresentationTime() {
        ZonedDateTime etTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime mtTime = etTime.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utcTime = etTime.withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a z");
        return String.format("ET: %s | MT: %s | UTC: %s",
                etTime.format(formatter),
                mtTime.format(formatter),
                utcTime.format(formatter));
    }
}

