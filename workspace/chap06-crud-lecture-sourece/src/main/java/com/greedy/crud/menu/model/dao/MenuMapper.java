package com.greedy.crud.menu.model.dao;

import com.greedy.crud.menu.model.dto.CategoryDTO;
import com.greedy.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategories();

    int registNewMenu(MenuDTO newMenu);
}
