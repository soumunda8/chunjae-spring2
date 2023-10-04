package kr.ed.haebeop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @GetMapping("/")
    public String ajaxHome() {
        return "/ajax/home";
    }

    @GetMapping("/test01")
    public String ajaxTest01() {
        return "/ajax/test01";
    }

    @GetMapping("/test01Pro")
    public String ajaxTest01Pro() {
        System.out.println("Get 전송 테스트");
        return "/ajax/test01";
    }

    @GetMapping("/test02")
    public String ajaxTest02() {
        return "/ajax/test02";
    }

    @PostMapping("/test02Pro")
    public String ajaxTest02Pro() {
        System.out.println("Post 전송 테스트");
        return "/ajax/test02";
    }

    @GetMapping("/test03")
    public String ajaxTest03() {
        return "/ajax/test03";
    }

    @GetMapping("/test03Pro")
    public String ajaxTest03Pro() {
        return "/ajax/test03";
    }

    @GetMapping("/test04")
    public String ajaxTest04() {
        return "/ajax/test04";
    }

    @PostMapping("/test04Pro")
    public String ajaxTest04Pro() {
        return "/ajax/test04";
    }

    @GetMapping("/test05")
    public String ajaxTest05() {
        return "/ajax/test05";
    }

    @GetMapping("/test05Pro")
    public String ajaxTest05Pro() {
        return "/ajax/test05";
    }

    @GetMapping("/test06")
    public String ajaxTest06() {
        return "/ajax/test06";
    }

    @PostMapping("/test06Pro")
    public String ajaxTest06Pro() {
        return "/ajax/test06";
    }

    @GetMapping("/test07")
    public String ajaxTest07() {
        return "/ajax/test07";
    }

    @PostMapping("/test07Pro")
    public String ajaxTest07Pro() {
        return "/ajax/test07";
    }

    @GetMapping("/test08Pro")
    public String ajaxTest08Pro() {
        return "/ajax/test08";
    }

    @PostMapping("/test08")
    public String ajaxTest08() {
        return "/ajax/test08";
    }

    @GetMapping("/test09Pro")
    public String ajaxTest09Pro() {
        return "/ajax/test09";
    }

    @PostMapping("/test09")
    public String ajaxTest09() {
        return "/ajax/test09";
    }

    @GetMapping("/test10Pro")
    public String ajaxTest10Pro() {
        return "/ajax/test10";
    }

    @PostMapping("/test10")
    public String ajaxTest10() {
        return "/ajax/test10";
    }

}