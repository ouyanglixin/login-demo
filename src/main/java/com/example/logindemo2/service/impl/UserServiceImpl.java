package com.example.logindemo2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.logindemo2.mapper.UserMapper;
import com.example.logindemo2.pojo.User;
import com.example.logindemo2.service.UserServic;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserServic {
}
