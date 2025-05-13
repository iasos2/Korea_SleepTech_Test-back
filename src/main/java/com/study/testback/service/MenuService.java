package com.study.testback.service;

import com.study.testback.dto.request.PostMenuRequestDto;
import com.study.testback.dto.response.MenuResponseDto;

public interface MenuService {

    // 메뉴 ID로 단일 메뉴 조회
    MenuResponseDto getMenuById(Long id);

    // 새로운 메뉴 생성
    MenuResponseDto createMenu(PostMenuRequestDto dto);

    // 메뉴 업데이트
    MenuResponseDto updateMenu(Long id, PostMenuRequestDto dto);

    // 메뉴 삭제
    void deleteMenu(Long id);

}
