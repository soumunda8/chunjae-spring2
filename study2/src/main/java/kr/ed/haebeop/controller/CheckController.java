package kr.ed.haebeop.controller;

import kr.ed.haebeop.test.Check;
import kr.ed.haebeop.test.CheckVO;
import kr.ed.haebeop.test.CheckValidator;
import kr.ed.haebeop.test.CheckValidator2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/check/")
public class CheckController {

    @GetMapping("check1")
    public String check1(Model model) {
        return "/check/check1";
    }

    @PostMapping("check1")
    public String check1Pro(@RequestParam String id, @RequestParam String pw, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/check/check1_result";
    }

    @GetMapping("check2")
    public String check2(Model model) {
        return "/check/check2";
    }

    @PostMapping("check2")
    public String check2Pro(HttpServletRequest request, Model model) {
        model.addAttribute("id", request.getParameter("id"));
        model.addAttribute("pw", request.getParameter("pw"));
        return "/check/check2_result";
    }

    @GetMapping("check3")
    public String check3(Model model) {
        return "/check/check3";
    }

    @GetMapping("check3Pro")
    public String check3Pro(@RequestParam String id, @RequestParam String pw, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "/check/check3_result";
    }

    @GetMapping("check4")
    public String check4(Model model) {
        return "/check/check4";
    }

    @PostMapping("check4")
    public String check4Pro(@ModelAttribute("check") Check check, Model model, BindingResult result) {
        String page = "/check/check4_result";                   // 폼의 유효성 검증시 알맞은 데이터이면
        CheckValidator ckVal = new CheckValidator();
        ckVal.validate(check, result);
        if(result.hasErrors()) {                                // 폼의 유효성 검증시 에러가 있으면, 에러페이지로 변경
            page = "/check/error4";
        }
        return page;
    }

    // 하나의 컨트롤러에서는 오로지 하나의 validator 만을 쓸 수 밖에 없다는 단점이 있음.
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new CheckValidator2());
    }

    @GetMapping("check5")
    public String check5(Model model) {
        return "/check/check5";
    }

    @PostMapping("check5")
    public String check5Pro(@ModelAttribute("check") @Valid CheckVO check, Model model, BindingResult result) {
        String page = "/check/check5_result";                   // 폼의 유효성 검증시 알맞은 데이터이면
        if(result.hasErrors()) {                                // 폼의 유효성 검증시 에러가 있으면, 에러페이지로 변경
            page = "/check/error5";
        }
        return page;
    }

    @GetMapping("check6")
    public String check6(Model model) {
        model.addAttribute("chk", new CheckVO());
        return "/check/check6";
    }

    @PostMapping("check6")
    public String check6Pro(@ModelAttribute("chk") @Valid CheckVO chk, BindingResult result, Model model){
        String page = "/check/check6";
        model.addAttribute("chk", chk);
        return page;
    }

}