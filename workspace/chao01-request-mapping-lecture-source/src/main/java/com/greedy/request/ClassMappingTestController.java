package com.greedy.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/order/*")
@Controller
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model) {

        model.addAttribute("message",
                "GET 방식의 주문 등록용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

    @RequestMapping(value={"modify", "remove"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {

        model.addAttribute("message",
                "POST 방식의 주문 정보 수정과 주문 정보 삭제 공동 처리용 핸들러 메소드 동작함...");

        return "mappingResult";
    }

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable int orderNo) {

        model.addAttribute("message",
                orderNo + "번 주문 상세 내용 조회용 핸들러 메소드 호출함...");

        return "mappingResult";
    }

}
