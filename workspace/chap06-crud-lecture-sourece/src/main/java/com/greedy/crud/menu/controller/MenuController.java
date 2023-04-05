package com.greedy.crud.menu.controller;

import com.greedy.crud.menu.model.dto.CategoryDTO;
import com.greedy.crud.menu.model.dto.MenuDTO;
import com.greedy.crud.menu.model.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("list")
    public ModelAndView findMenuList(ModelAndView mv) {

        List<MenuDTO> menuList = menuService.findAllMenus();
        menuList.forEach(System.out::println);

        mv.addObject("menuList", menuList);
        mv.setViewName("menu/list");


        return mv;
    }

    @GetMapping("regist")
    public void regist() {}

    @GetMapping(value="categories")
    @ResponseBody
    public List<CategoryDTO> findAllCategories() {

        menuService.findAllCategories().forEach(System.out::println);

        return menuService.findAllCategories();
    }

    @PostMapping("regist")
    public ModelAndView registMenu(ModelAndView mv
            , RedirectAttributes rttr
            , MenuDTO newMenu) {


        menuService.registNewMenu(newMenu);
        rttr.addFlashAttribute("successMessage",
                    "신규 메뉴 등록에 성공하셨습니다.");
        mv.setViewName("redirect:/menu/list");

        return  mv;
    }
}
