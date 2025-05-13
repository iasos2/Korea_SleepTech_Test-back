package com.study.testback.controller;

import com.study.testback.dto.request.PostMenuRequestDto;
import com.study.testback.dto.response.MenuResponseDto;
import com.study.testback.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    // 메뉴 생성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuResponseDto createMenu(@RequestBody PostMenuRequestDto requestDto) {
        return menuService.createMenu(requestDto);
    }

    // 메뉴 조회
    @GetMapping("/{id}")
    public MenuResponseDto getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    // 메뉴 업데이트
    @PutMapping("/{id}")
    public MenuResponseDto updateMenu(
            @PathVariable Long id,
            @RequestBody PostMenuRequestDto requestDto) {
        return menuService.updateMenu(id, requestDto);
    }

    // 메뉴 삭제
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}
