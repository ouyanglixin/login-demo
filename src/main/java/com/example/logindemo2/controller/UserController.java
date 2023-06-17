package com.example.logindemo2.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.logindemo2.mapper.UserMapper;
import com.example.logindemo2.pojo.Result;
import com.example.logindemo2.pojo.User;
import com.example.logindemo2.service.UserServic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.NestingKind;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserServic userServic;

    @PostMapping("/login")
    public String login (String username , String password) {
        log.info("用户名为：{}，密码：{}",username,password);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> eq = queryWrapper.eq(User::getUsername, username).eq(User::getPassword, password);
        User one = userServic.getOne(queryWrapper);
        return one != null ? getResult("登入成功",1,username) : getResult("用户名或密码错误！",0,"");
    }
    @PostMapping("/register")
    public String register (String username , String password , Integer usertype ,  String entrydate,
    Integer gender ,@RequestParam List<String> hobby, String email,String introduce) {
        log.info("注册用户名为：{}，密码为：{},usertype:{},entrydate:{},gender:{},hobby:{},email:{},introduce:{}"
                ,username,password,usertype,entrydate,gender,hobby,email,introduce);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> eq = queryWrapper.eq(User::getUsername, username);
        User user_name_exit = userServic.getOne(queryWrapper);
           if (user_name_exit == null) {
               // 这个用户不存在则创建
               User user = new User(null,username,password,usertype,gender,entrydate,hobby.get(0),email,introduce);
               boolean save = userServic.save(user);
               return getResult("注册成功",2,username);
           }
        return getResult(username+"-用户,已经存在，请重写注册！！！",0,"");
    }


    public static String getResult (String info ,Integer code ,String user) {
        String color = "";
        if (code == 1) {
            color = "#259445";
        }else if (code == 0){
            color = "#e63f32";
        } else {
            color = "#259445";
            String datas = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Document</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"./css/common.css\">\n" +
                    "    <style>\n" +
                    "        .box {\n" +
                    "            width: 400px;\n" +
                    "            height: 300px;\n" +
                    "            display: flex;\n" +
                    "            flex-direction: column;\n" +
                    "            justify-content: center;\n" +
                    "            align-items: center;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"box tou\" >\n" +
                    "        <h1 style=\"color: #259445; font-size: 35px; white-space: nowrap\">"+user+"-注册成功！！！</h1>\n" +
                    "        <a class=\"register tou\" href=\"./index.html\" style=\"margin: 10px 0;\">登入</a>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>";
            return datas;
        }
        String data = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Document</title>\n" +
                "    <link rel=\"stylesheet\" href=\"./css/common.css\">\n" +
                "    <style>\n" +
                "        .box {\n" +
                "            width: 400px;\n" +
                "            height: 300px;\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"box tou\" >\n" +
                "        <h1 style=\"color:"+color+"; font-size: 35px;  white-space: nowrap\">"+user+info+"</h1>\n" +
                "        <a class=\"register tou\" href=\"./index.html\" style=\"margin: 10px 0;\">重新登入</a>\n" +
                "        <a class=\"register tou\" href=\"./register.html\">注册</a>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        return data;
    }
}
