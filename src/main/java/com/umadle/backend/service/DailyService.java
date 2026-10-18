package com.umadle.backend.service;

import com.umadle.backend.dto.response.DailyUmaResponse;
import com.umadle.backend.entity.Uma;
import com.umadle.backend.repository.UmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyService {

    private static final LocalDate EPOCH = LocalDate.of(2025, 6, 26);

    private final UmaRepository umaRepository;

    private LocalDate todayKey() {
        return LocalDate.now(ZoneOffset.UTC);
    }

    public DailyUmaResponse dailyUma() {
        List<Uma> roster = umaRepository.findAll(Sort.by("id"));
        if (roster.isEmpty()) {
            throw new IllegalStateException("Roster is empty; cannot pick a daily uma.");
        }
        LocalDate today = todayKey();
        long dayNumber = ChronoUnit.DAYS.between(EPOCH, today);

        int index = (int) (((dayNumber % roster.size()) + roster.size()) % roster.size());

        return DailyUmaResponse.builder()
                .dayKey(today.toString())
                .answerId(roster.get(index).getId())
                .build();
    }
}
