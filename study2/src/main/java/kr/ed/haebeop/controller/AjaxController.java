package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Human;
import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    private TestService testService3;

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
    public String ajaxTest03Pro(@RequestParam("msg") String msg) {
        System.out.println(msg);
        return "/ajax/test03";
    }

    @GetMapping("/test04")
    public String ajaxTest04() {
        return "/ajax/test04";
    }

    @PostMapping("/test04Pro")
    public String ajaxTest04Pro(@RequestParam("msg") String msg) {
        System.out.println(msg);
        return "/ajax/test04";
    }

    @GetMapping("/test05")
    public String ajaxTest05() {
        return "/ajax/test05";
    }

    @GetMapping("/test05Pro")
    @ResponseBody
    public Human ajaxTest05Pro(@ModelAttribute("human") Human human) {
        System.out.println(human.toString());
        return human;
    }

    @GetMapping("/test06")
    public String ajaxTest06() {
        return "/ajax/test06";
    }

    @PostMapping("/test06Pro")
    @ResponseBody
    public Human ajaxTest06Pro(@ModelAttribute("human") Human human) {
        System.out.println(human.toString());
        return human;
    }

    @GetMapping("/test07")
    public String ajaxTest07() {
        return "/ajax/test07";
    }

    @PostMapping("/test07Pro")
    @ResponseBody
    public Human ajaxTest07Pro(@RequestBody Human human) {
        System.out.println(human.toString());
        return human;
    }

    @GetMapping("/test08")
    public String ajaxTest08() {
        return "/ajax/test08";
    }

    @PostMapping("/test08Pro")
    @ResponseBody
    public List<TestVO> ajaxTest08Pro(@RequestBody TestVO test) throws Exception {
        System.out.println(test.toString());
        testService3.testInsert(test);
        List<TestVO> tList = testService3.testList();
        return tList;
    }

    @GetMapping("/test09")
    public String ajaxTest09() {
        return "/ajax/test09";
    }

    @PostMapping("/test09Pro")
    public ResponseEntity ajaxTest09Pro(@RequestBody TestVO test) {
        System.out.println(test.toString());
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @GetMapping("/test10")
    public String ajaxTest10() {
        return "/ajax/test10";
    }

    @PostMapping("/test10Pro")
    public ResponseEntity ajaxTest10Pro(@RequestBody TestVO test) throws Exception {
        testService3.testInsert(test);
        List<TestVO> tList = testService3.testList();
        return new ResponseEntity<>(tList, HttpStatus.OK);
    }

}