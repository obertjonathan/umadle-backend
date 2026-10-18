package com.umadle.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "uma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Uma {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "bust")
    private int bust;

    @Column(name = "waist")
    private int waist;

    @Column(name = "hip")
    private int hip;

    @Column(name = "height")
    private int height;

    @Column(name = "image_url")
    @JsonProperty("image")
    private String imageUrl;
}
