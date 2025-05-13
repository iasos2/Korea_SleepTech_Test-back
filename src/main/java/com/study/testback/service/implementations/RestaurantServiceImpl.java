package com.study.testback.service.implementations;

import com.study.testback.dto.request.PostRestaurantRequestDto;
import com.study.testback.dto.response.PostRestaurantResponseDto;
import com.study.testback.dto.response.RestaurantResponseDto;
import com.study.testback.entity.Restaurant;
import com.study.testback.repository.MenuRepository;
import com.study.testback.repository.RestaurantRepository;
import com.study.testback.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Override
    public PostRestaurantResponseDto createRestaurant(PostRestaurantRequestDto requestDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(requestDto.getName());
        restaurant.setAddress(requestDto.getAddress());
        restaurant.setPhoneNumber(requestDto.getPhoneNumber());

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return new PostRestaurantResponseDto(
                savedRestaurant.getId(),
                savedRestaurant.getName(),
                savedRestaurant.getAddress(),
                savedRestaurant.getPhoneNumber()
        );
    }

    @Override
    public RestaurantResponseDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 레스토랑을 찾을 수 없습니다: " + id));

        return new RestaurantResponseDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getPhoneNumber()
        );
    }

    @Override
    public RestaurantResponseDto updateRestaurant(Long id, PostRestaurantRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 레스토랑을 찾을 수 없습니다: " + id));

        restaurant.setName(requestDto.getName());
        restaurant.setAddress(requestDto.getAddress());
        restaurant.setPhoneNumber(requestDto.getPhoneNumber());

        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return new RestaurantResponseDto(
                updatedRestaurant.getId(),
                updatedRestaurant.getName(),
                updatedRestaurant.getAddress(),
                updatedRestaurant.getPhoneNumber()
        );
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 ID의 레스토랑을 찾을 수 없습니다: " + id));

        menuRepository.deleteAll(restaurant.getMenus());
        restaurantRepository.delete(restaurant);
    }
}
