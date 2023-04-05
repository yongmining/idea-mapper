package com.greedy.crud.menu.model.service;

import com.greedy.crud.menu.model.dao.MenuMapper;
import com.greedy.crud.menu.model.dto.CategoryDTO;
import com.greedy.crud.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements  MenuService{

    private final MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }
    @Override
    public List<MenuDTO> findAllMenus() {

        return menuMapper.findAllMenus();
    }

    @Override
    public List<CategoryDTO> findAllCategories() {

        return menuMapper.findAllCategories();
    }

    @Override
    @Transactional
    public void registNewMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);


    }
}
