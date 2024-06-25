package com.foodiefy.mainservice.service;

import com.foodiefy.mainservice.dto.MenuDto;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface MenuService {
    //crud operations -> create, read, update, delete

    List<MenuDto> getAllMenus();

    MenuDto getMenuById(long id);

    String addMenu(MenuDto menuDto);

    String updateMenu(MenuDto menuDto, long id);

    String deleteMenu(long id);
}
