package com.greedy.crud.menu.model.service;

import com.greedy.crud.menu.model.dto.CategoryDTO;
import com.greedy.crud.menu.model.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategories();

    void registNewMenu(MenuDTO newMenu);
}
