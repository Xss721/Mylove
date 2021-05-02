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
        if (!loginService.logCheck(username, password)) {
            attributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/login";
        } else {
            session.setAttribute("user", username);
            return "redirect:/index";
        }
    }

    //  user 注册界面
    @PostMapping(value = "/login/addUser")
    public String logAddUser(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("password2") String password2,
                             HttpSession session,
                             RedirectAttributes attributes) {
//        System.out.println(String.valueOf(loginService.selectByUsername(username)));
        if (loginService.selectByUsername(username)!=0 || !password2.equals(password)) {
            attributes.addFlashAttribute("msg", "密码不一致或用户名不可用");
        } else {
            loginService.AddNewUser(username, password);
            attributes.addFlashAttribute("msg", "注册成功，请登录");
        }
        return "redirect:/login";
    }

    @GetMapping("/index")
    public String returnindex() {
        return "index";
    }
}
