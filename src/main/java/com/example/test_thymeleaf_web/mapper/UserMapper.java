package com.example.test_thymeleaf_web.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test_thymeleaf_web.bean.User;

/**
 * 继承BaseMapper 主要是为了继承大量的基础操作的功能函数,拥有CRUD功能
 *
 * */
public interface UserMapper extends BaseMapper<User> {

}
