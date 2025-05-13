package com.study.testback.controller;

import com.study.testback.dto.request.PostRestaurantRequestDto;
import com.study.testback.dto.response.PostRestaurantResponseDto;
import com.study.testback.dto.response.RestaurantResponseDto;
import com.study.testback.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    // 레스토랑 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostRestaurantResponseDto createRestaurant(@RequestBody PostRestaurantRequestDto requestDto) {
        return restaurantService.createRestaurant(requestDto);
    }

    // 레스토랑 조회
    @GetMapping("/{id}")
    public RestaurantResponseDto getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    // 레스토랑 업데이트
    @PutMapping("/{id}")
    public RestaurantResponseDto updateRestaurant(
            @PathVariable Long id,
            @RequestBody PostRestaurantRequestDto requestDto) {
        return restaurantService.updateRestaurant(id, requestDto);
    }

    // 레스토랑 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }
}
