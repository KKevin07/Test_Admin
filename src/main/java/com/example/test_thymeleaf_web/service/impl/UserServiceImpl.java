package com.example.test_thymeleaf_web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test_thymeleaf_web.bean.User;
import com.example.test_thymeleaf_web.mapper.UserMapper;
import com.example.test_thymeleaf_web.service.UserService;
import org.springframework.stereotype.Service;
//ServiceImpl<UserMapper, User>     第一项传Mapper  第二项传要操作的数据表   ServiceImpl中含有大量的操作函数
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
