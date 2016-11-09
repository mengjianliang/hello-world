package com.next.controller;

import com.next.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianliang.meng on 2016/11/8.
 */
@Controller
public class AjaxController {

    @RequestMapping("/ajax")
    public void ajax(String name, HttpServletResponse response) throws IOException {

        System.out.println("name="+name);
        if("mengjianliang".equals(name)){
            response.getWriter().println("ture");
        }else{
            response.getWriter().println("false");

        }

    }

    @RequestMapping("/json")
    @ResponseBody
    public List<User> json(){
        List<User> list = new ArrayList<User>();


        return list;
    }

}
