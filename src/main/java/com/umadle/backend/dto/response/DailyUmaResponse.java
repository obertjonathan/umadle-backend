package com.umadle.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class DailyUmaResponse {
    private String dayKey;
    private String answerId;
}
