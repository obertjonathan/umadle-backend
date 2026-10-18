package com.umadle.backend.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umadle.backend.entity.Uma;
import com.umadle.backend.repository.UmaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.List;

/**
 * Upserts the roster from classpath:data/umas.json on every startup.
 * Rows are keyed by id, so editing the JSON and restarting adds new umas
 * and updates existing ones. Rows removed from the JSON are NOT deleted.
 */
@Slf4j
@Configuration
public class DataSeeder {

    private static final String ROSTER_FILE = "data/umas.json";

    @Bean
    CommandLineRunner seedUmas(UmaRepository repository, ObjectMapper objectMapper) {
        return args -> {
            List<Uma> umas;
            try (InputStream in = new ClassPathResource(ROSTER_FILE).getInputStream()) {
                umas = objectMapper.readValue(in, new TypeReference<>() {});
            }
            repository.saveAll(umas);
            log.info("Seeded {} umas from {}", umas.size(), ROSTER_FILE);
        };
    }
}
