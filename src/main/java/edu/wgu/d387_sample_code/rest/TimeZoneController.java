package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.TimeZoneConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeZoneController {

    @GetMapping("/api/presentation-time")
    public String getPresentationTime() {
        return TimeZoneConverter.convertPresentationTime();
    }
}

