package com.next.controller;

import com.next.service.UserService;
import com.next.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jianliang.meng on 2016/11/8.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/select")
    public String list(ModelMap map){
        map.addAttribute("list",userService.list());
        return "/list.jsp";
    }

    @RequestMapping("/update")
    public String update(int id,String name,String password,ModelMap map){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        System.out.println(name);
        System.out.println(password);
        userService.update(user);

        map.addAttribute("list",userService.list());
        return "/list.jsp";
    }

    @RequestMapping("/delete")
    public String delete(int id,ModelMap map){

        userService.delete(id);

        map.addAttribute("list",userService.list());
        return "/list.jsp";
    }

    @RequestMapping("/insert")
    public String insert(String name,String password,ModelMap map){
        System.out.println("插入数据");
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        System.out.println("name:"+name+"password:"+password);
        userService.save(user);
        System.out.println(user.getId());
        map.addAttribute("list",userService.list());
        return "/list.jsp";
    }




}
