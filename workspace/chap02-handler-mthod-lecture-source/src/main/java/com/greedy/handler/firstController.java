package com.greedy.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.WebSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class firstController {

    /* GET 방식이 /first/regist 요청이 들어오면
    * void 형의 메소드인 경우 요청 경로와 동일한 뷰 페이지로
    * 포워딩을 한다
    * return "/first/regist"; 와 같은 의미를 가진다.
    * */
    @GetMapping("regist")
    public void regist() {}

    @PostMapping("regist")
//    public String registMenu(Model model, HttpServletRequest request) {
      public  String registMenu(Model model, WebRequest request) {

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 "
                + price + "원으로 등록하셨습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public  void modify() {}

    @PostMapping("modify")
    public String modifyMenuPrice(Model model,
                                  @RequestParam(required = false) String modifyName,
                                  @RequestParam(defaultValue = "0") int modifyPrice) {

        String message = modifyName + "메뉴의 가격을 " +
                modifyPrice + "로 가격을 변경하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modify-all")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters) {

        String modifyMenu = parameters.get("modifyName2");
        int modifyPrice = Integer.parseInt(parameters.get("modifyPrice2"));

        String message = "메뉴의 이름을 " + modifyMenu + "으로, 가격을 "
                + modifyPrice + "원으로 변경하였습니다.";
        model.addAttribute("message", message);

        return  "first/messagePrinter";

    }

    @GetMapping("search")
    public void search() {}

    @PostMapping("search")
    public  String searchMenu(@ModelAttribute("menu") MenuDTO menu) {

        System.out.println("menu = " + menu);

        return "first/searchResult";
    }

    @GetMapping("login")
    public void login() {}

    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {

        session.setAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {

        session.invalidate();

        return "first/loginResult";
    }

    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {

        model.addAttribute("id", id);

        return "first/loginResult";
    }

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return  "first/loginResult";
    }

    @GetMapping("body")
    public void body() {}

    @PostMapping("body")
    public void bodyTest(@RequestBody String body
            , @RequestHeader("content-type") String contentType) {

        System.out.println("body = " + body);
        System.out.println("URLDecoder.decode(body) = " + URLDecoder.decode(body));
        System.out.println("contentType = " + contentType);
    }
}

