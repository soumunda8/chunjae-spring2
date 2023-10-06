package kr.ed.haebeop.controller;

import org.dom4j.rule.Mode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LocaleController {

    private static final Logger log = LoggerFactory.getLogger(LocaleController.class);

    @Autowired
    SessionLocaleResolver localeResolver;

    @Autowired
    MessageSource messageSource;

    @RequestMapping("/locale/lang1")
    public String callLocale1(Locale locale, HttpServletRequest request, Model model) {
        log.info("Session locale is {}.", localeResolver.resolveLocale(request));
        return "/test/localeTest";
    }

    @RequestMapping("/locale/lang2")
    public String callLocale2(@RequestParam("lang") String language, HttpServletRequest request, HttpServletResponse response, Model model) {
        Locale locale = new Locale(language);
        localeResolver.setLocale(request, response, locale);
        log.info("Session locale is {}.", localeResolver.resolveLocale(request));
        return "/test/localeTest";
    }

}