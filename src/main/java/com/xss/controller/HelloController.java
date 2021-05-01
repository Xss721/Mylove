package com.xss.controller;

import com.xss.service.impl.loginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class HelloController {
    @Autowired
    private loginServiceImpl loginService;

    // 未登录者提示登录
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    //    成功登录要展示的页面
    @PostMapping(value = "/login/log")
    public String loginSuccess(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               RedirectAttributes attributes) {

        if (loginService.selectPasswordByUsername(username, password)) {
            session.setAttribute(String.valueOf(loginService.selectByUsername(username)),username);
            return "index";
        }
        else return "redirect:/login/log";
    }

    @PostMapping(value = "/login/addUser")
    public String logAddUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("password2") String password2,
                             HttpSession session,
                             RedirectAttributes attributes) {
        if (password2.equals(password) && loginService.AddNewUser(username, password)) {

            return "index";
        } else return "redirect:/login";
    }

    @GetMapping("/index")
    public String returnindex() {
        return "index";
    }
}
