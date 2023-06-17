package com.example.logindemo2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    //用户类型
    private Integer usertype;

    public User(Integer id, String username, String password, Integer usertype, Integer gender, String entryDate, String hobby, String email, String introduce) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.gender = gender;
        this.entryDate = entryDate;
        this.hobby = hobby;
        this.email = email;
        this.introduce = introduce;
    }

    //性别
    private Integer gender;

    //出生日期
    private String entryDate;

    // 兴趣
    private String hobby;

    // 邮箱
    private String email;

    // 自我介绍
    private  String introduce;
}
