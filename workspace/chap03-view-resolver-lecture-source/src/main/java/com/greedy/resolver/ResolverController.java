package com.greedy.resolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {

        model.addAttribute("forwardMessage",
                "문자열로 뷰 이름 변환함");

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(Model model) {

        model.addAttribute("message1", "문자열로 뷰 이름 변환하며 리다이렉트...");

        return "redirect:/";
    }

    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttribute(RedirectAttributes rttr) {
        
        /* 세션에 임시로 값을 담고 소멸하는 방식이기 때문에 session에 동일한 키값이 존재하지 않아야 한다.
        * 값을 꺼내 사용할 때는 requestScope라고 생각하고 꺼내서 사용한다.
        * */
        rttr.addFlashAttribute("flashMessage1", "리다이렉트 attr 사용하여 redirect..");

        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelAndViewReturning(ModelAndView mv) {

        mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");
        mv.setViewName("result");

        return mv;
    }

    @GetMapping("modelandview-redirect")
    public ModelAndView modelAndViewRedirect(ModelAndView mv) {

        mv.addObject("message2", "ModelAndView를 이용한 redirect...");
        mv.setViewName("redirect:/");

        return mv;
    }

    @GetMapping("modelandview-redirect-attr")
    public ModelAndView modelAndViewRedirect(ModelAndView mv, RedirectAttributes rttr) {

        rttr.addFlashAttribute("flashMessage2",
                "ModelAndView를 이용한 redirect attr");
        mv.setViewName("redirect:/");

        return mv;
    }
}
