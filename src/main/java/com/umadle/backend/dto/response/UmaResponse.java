package com.umadle.backend.dto.response;

import com.umadle.backend.entity.Uma;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UmaResponse {
    private String id;
    private String name;
    private int bust;
    private int waist;
    private int hip;
    private int height;
    private String image;

    public static UmaResponse from(Uma uma) {
        return UmaResponse.builder()
                .id(uma.getId())
                .name(uma.getName())
                .bust(uma.getBust())
                .waist(uma.getWaist())
                .hip(uma.getHip())
                .height(uma.getHeight())
                .image(uma.getImageUrl())
                .build();
    }
}
