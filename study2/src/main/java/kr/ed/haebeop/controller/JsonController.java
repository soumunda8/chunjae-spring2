package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.TestVO;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/json/")
public class JsonController {

    @Autowired
    private TestService testService3;

    @GetMapping("getTest/{num}")
    @ResponseBody
    public TestVO viewTest(@PathVariable int num) throws Exception {
        TestVO test = testService3.getTest(num);
        return test;
    }

    @GetMapping("insertForm")
    public String insertForm() throws Exception {
        return "/test/testInsert";
    }

    @PostMapping("insertForm")
    @ResponseBody
    public TestVO insertFormPro(@ModelAttribute TestVO test) throws Exception {
        TestVO testVO = test;
        testService3.testInsert(test);
        return testVO;
    }

    @GetMapping("insertForm2")
    public String insertForm2() throws Exception {
        return "/test/testInsert2";
    }

    @PostMapping("insertForm2")
    @ResponseBody
    public TestVO insertFormPro2(@RequestBody TestVO test) throws Exception {
        TestVO testVO = test;
        testService3.testInsert(test);
        return testVO;
    }

}