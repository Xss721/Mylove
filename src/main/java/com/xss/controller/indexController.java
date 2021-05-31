package com.xss.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xss.pojo.anniversary;
import com.xss.service.impl.anniversaryServcieImpl;
import com.xss.service.impl.loginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
* 已经登录后用户展示的界面
* */
@Slf4j
@Controller
public class indexController {

    @Autowired
    private anniversaryServcieImpl anniversaryServcie;

    @Autowired
    private loginServiceImpl loginService;

    @GetMapping("/index/{pageNum}")
    public String getAnniversary(HttpSession session , Model model,@RequestParam(value = "pageNum") String pageNum){
        System.out.println(pageNum);
        String username = (String) session.getAttribute("user");
        System.out.println(username);
        IPage<anniversary> anniversaries =  anniversaryServcie.selectByUserId(loginService.selectByUsername(username),Integer.getInteger(pageNum));

//        List<anniversary> anniversaries =  anniversaryServcie.selectanniversaryByUserId(loginService.selectByUsername(username));
//        for (anniversary anniversary : anniversaries) {
//            System.out.println(anniversary.getAnniversaryid());
//            System.out.println(anniversary.getAnniversarytext());
//            System.out.println(anniversary.getAnniversarytime());
//        }
        model.addAttribute("anniversaries",anniversaries);
        return "index";
    }

//    @GetMapping("/index")
//    public String returnindex(HttpSession session , Model model) {
//        String username = (String) session.getAttribute("user");
//        System.out.println(username);
////        IPage<anniversary> anniversaries =  anniversaryServcie.selectByUserId(loginService.selectByUsername(username),Integer.getInteger(pageNum));
//
//        List<anniversary> anniversaries =  anniversaryServcie.selectanniversaryByUserId(loginService.selectByUsername(username));
//        for (anniversary anniversary : anniversaries) {
//            System.out.println(anniversary.getAnniversaryid());
//            System.out.println(anniversary.getAnniversarytext());
//            System.out.println(anniversary.getAnniversarytime());
//        }
//        model.addAttribute("anniversaries",anniversaries);
//        return "index";
//    }


    @GetMapping("/index")
    public String getIndex(HttpSession session , Model model) {
        String username = (String) session.getAttribute("user");
        System.out.println(username);
        System.out.println(loginService.selectByUsername(username));

        IPage<anniversary> anniversaries2 =  anniversaryServcie.selectByUserId(loginService.selectByUsername(username),2);
        for (anniversary record : anniversaries2.getRecords()) {
            System.out.println(record.toString());
        }
        List<anniversary> anniversaries = anniversaries2.getRecords();
        model.addAttribute("anniversaries",anniversaries);
        return "index";
    }
}
