package com.umadle.backend.controller;

import com.umadle.backend.dto.response.UmaResponse;
import com.umadle.backend.service.UmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/uma")
@RequiredArgsConstructor
public class UmaController {

    private final UmaService umaService;

    @GetMapping
    public List<UmaResponse> all() {
        return umaService.getUmaRoster();
    }
}
