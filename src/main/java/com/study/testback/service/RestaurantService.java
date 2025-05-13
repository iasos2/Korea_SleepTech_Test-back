package com.study.testback.service;

import com.study.testback.dto.request.PostRestaurantRequestDto;
import com.study.testback.dto.response.PostRestaurantResponseDto;
import com.study.testback.dto.response.RestaurantResponseDto;

public interface RestaurantService {

    // 레스토랑 생성
    PostRestaurantResponseDto createRestaurant(PostRestaurantRequestDto dto);

    // 특정 레스토랑 조회
    RestaurantResponseDto getRestaurantById(Long id);

    // 레스토랑 업데이트
    RestaurantResponseDto updateRestaurant(Long id, PostRestaurantRequestDto dto);

    // 레스토랑 삭제
    void deleteRestaurant(Long id);
}
