package com.zcl.web;

import com.zcl.NotFoundExcepiton;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 项目名称：blogger
 * 描述：首页控制器
 *
 * @author zhong
 * @date 2022-06-24 21:24
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }
}
