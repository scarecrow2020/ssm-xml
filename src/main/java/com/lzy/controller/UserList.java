package com.lzy.controller;

import com.lzy.mapper.UserMapper;
import com.lzy.model.User;
import com.lzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserList {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUserPage")
    public Object findUserPage() {
        return userService.findUserPage(1L, 3L );
    }

    @RequestMapping("/batchInsert")
    public Object batchInsert() {
        List<User> users = new ArrayList<>();
        String[] names = new String[]{"e","f","g","h","i"};
        int age = 16;
        for (String name: names) {
            User user = new User();
            user.setName(name);
            user.setAge(age+1);
            user.setCardCode("cardCode"+age);
            user.setBirthday(new Date());
            user.setCreateDate(new Date());
            user.setOperateDate(new Date());
            user.setOperateUserId(1L);
            age ++;
            users.add(user);
        }
        userService.batchInsert(users);
        return "success";
    }

    @RequestMapping("/findUsers")
    public Object findUsers(String name) {
        List<User> users = userService.findUsers();
        return users;
    }
    @RequestMapping("/insertUser")
    public Object insertUser() {
        User user = new User();
        user.setName("zz");
        user.setAge(11);
        user.setCardCode("cardCode"+11);
        user.setBirthday(new Date());
        user.setCreateDate(new Date());
        user.setOperateDate(new Date());
        user.setOperateUserId(1L);
        return userService.insertUser(user);
    }
}
