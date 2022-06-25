package com.zcl.web.admin;

import com.zcl.pojo.User;
import com.zcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 项目名称：blogger
 * 描述：登录控制器
 *
 * @author zhong
 * @date 2022-06-25 12:20
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;


    /**
     * 跳转登录页面
     * @return
     */
    @GetMapping
    public String LoginPage(){
        return "admin/login";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes){
        System.out.println("获取用户名："+username);
        System.out.println("获取密码："+password);
        User user = userService.checkUser(username, password);
        if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",session);
            // 跳转登录首页
            return "admin/index";
        }else{
            // 给前端页面提示
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin";
        }
    }

    /**
     * 注销登录
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
