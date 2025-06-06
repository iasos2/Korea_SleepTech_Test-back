package com.study.testback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostMenuResponseDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private RestaurantResponseDto restaurant;

}
