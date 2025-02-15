package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeZoneService {

    /**
     * Method to calculate and format presentation times in ET, MT, and UTC.
     *
     * @return A formatted string containing the times for ET, MT, and UTC.
     */
    public String getPresentationTimes() {
        // Define the presentation time in Eastern Time (ET)
        ZonedDateTime presentationTimeET = ZonedDateTime.of(
                2025, 2, 15, 10, 0, 0, 0, ZoneId.of("America/New_York"));

        // Convert the presentation time to Mountain Time (MT) and UTC
        ZonedDateTime presentationTimeMT = presentationTimeET.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime presentationTimeUTC = presentationTimeET.withZoneSameInstant(ZoneId.of("UTC"));

        // Format the times for display
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a z");
        String formattedET = presentationTimeET.format(formatter);
        String formattedMT = presentationTimeMT.format(formatter);
        String formattedUTC = presentationTimeUTC.format(formatter);

        // Return the formatted time zone string
        return String.format("ET: %s, MT: %s, UTC: %s", formattedET, formattedMT, formattedUTC);
    }
}

