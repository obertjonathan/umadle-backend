package com.umadle.backend.controller;

import com.umadle.backend.dto.response.DailyUmaResponse;
import com.umadle.backend.service.DailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/daily")
@RequiredArgsConstructor
public class DailyController {

    private final DailyService dailyService;

    @GetMapping(value = "/uma", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> today() {
        DailyUmaResponse response = dailyService.dailyUma();

        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }
}
