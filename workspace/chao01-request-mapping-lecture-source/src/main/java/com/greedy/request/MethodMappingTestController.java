package com.greedy.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {

        System.out.println("regisMenu() 호출됨...");
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출함...");

        /* ThymeleafViewResolver가
        * 접두사 /resoucers/templates/
        * 접미사 .html
        * 을 붙여서 뷰 페이지의 경로를 해석한다.
        * */
        return "mappingResult";
    }

    @RequestMapping(value="/menu/modify", method  = RequestMethod.GET)
    public String modifyMenu(Model model) {

        model.addAttribute("message",
                "GET 방식의 메뉴 수정을 핸들러 메소드  호출함...");

        return "mappingResult";
    }

    /* 요청 메소드 별 전용 어노테이션 (since 4.3
    * 핸들러 메소드를 조금 더 간결하게 코딩할 수 있도록 해준다.
    * 요청 메소드                어노테이션
    * POST                    @PostMapping
    * GET                     @GetMapping
    * DELETE                  @DeleteMapping
    * PUT                     @PutMapping
    * */
    @GetMapping("/menu/remove")
    public String getRemoveMenu(Model model) {

        model.addAttribute("message",
                "GET 방식의 삭제용 핸들러 메소드 동작함...");

        return "mappingResult";
    }

    @PostMapping("/menu/remove")
    public String postRemoveMapping(Model model) {

        model.addAttribute("message",
                "POST 방식의 삭제용 핸들러 메소드 동작함...");

        return  "mappingResult";
    }
}
