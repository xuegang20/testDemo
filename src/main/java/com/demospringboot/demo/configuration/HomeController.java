package com.demospringboot.demo.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author xg
 * @Date 2018/9/17 16:19
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "redirect:swagger-ui.html";
    }
}
