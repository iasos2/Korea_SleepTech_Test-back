package com.study.testback.service.implementations;

import com.study.testback.dto.request.PostMenuRequestDto;
import com.study.testback.dto.response.MenuResponseDto;
import com.study.testback.entity.Menu;
import com.study.testback.entity.Restaurant;
import com.study.testback.repository.MenuRepository;
import com.study.testback.repository.RestaurantRepository;
import com.study.testback.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public abstract class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuServiceImpl(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MenuResponseDto getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "메뉴를 찾을 수 없습니다"));
        return new MenuResponseDto(menu.getId(), menu.getName(), menu.getPrice(), menu.getDescription());
    }

    @Override
    public MenuResponseDto createMenu(PostMenuRequestDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "레스토랑을 찾을 수 없습니다"));

        Menu menu = new Menu(dto.getName(), dto.getPrice(), dto.getDescription(), restaurant);
        Menu savedMenu = menuRepository.save(menu);

        return new MenuResponseDto(savedMenu.getId(), savedMenu.getName(), savedMenu.getPrice(), savedMenu.getDescription());
    }

    @Override
    public MenuResponseDto updateMenu(Long id, PostMenuRequestDto dto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "메뉴를 찾을 수 없습니다"));

        menu.setName(dto.getName());
        menu.setPrice(dto.getPrice());
        menu.setDescription(dto.getDescription());

        Menu updatedMenu = menuRepository.save(menu);

        return new MenuResponseDto(updatedMenu.getId(), updatedMenu.getName(), updatedMenu.getPrice(), updatedMenu.getDescription());
    }

    @Override
    public void deleteMenu(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "메뉴를 찾을 수 없습니다"));

        menuRepository.delete(menu);
    }

}
