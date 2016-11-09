package com.next.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jianliang.meng on 2016/11/7.
 */
@Controller
public class ComponentController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        System.out.println("hello springmvc");

        return "redirect:/index.jsp";
    }

    @RequestMapping("/hello2")
    public String hello2(String name, ModelMap model){
        System.out.println("hello springmvc:"+name);
        model.addAttribute("name",name);
        return "hello";
    }
}
