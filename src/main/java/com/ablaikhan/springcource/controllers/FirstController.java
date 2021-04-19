package com.ablaikhan.springcource.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpServletRequest;


@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request ){
        String name = request.getParameter("name")

        return "/first/hello";
    }


    @GetMapping("/goodbye")
    public String goodbyePage (){
        return "/first/goodbye";
    }
}
