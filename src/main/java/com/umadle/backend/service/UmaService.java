package com.umadle.backend.service;

import com.umadle.backend.dto.response.UmaResponse;
import com.umadle.backend.entity.Uma;
import com.umadle.backend.repository.UmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UmaService {

    private final UmaRepository umaRepository;

    private List<Uma> getRoster() {
        return umaRepository.findAll(Sort.by("id"));
    }

    public List<UmaResponse> getUmaRoster() {
        return getRoster().stream()
                .map(UmaResponse::from)
                .toList();
    }
}
