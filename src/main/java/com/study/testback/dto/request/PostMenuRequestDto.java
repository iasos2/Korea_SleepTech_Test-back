package com.study.testback.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostMenuRequestDto {
    private String name;
    private Double price;
    private String description;
    private Long restaurantId;
}
