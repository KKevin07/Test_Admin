package com.example.test_thymeleaf_web.service.impl;


import com.example.test_thymeleaf_web.bean.Account;
import com.example.test_thymeleaf_web.mapper.AccountMapper;
import com.example.test_thymeleaf_web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//实现类，来实现对应的接口。有利于开发规范，实现解耦
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;



    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }

}
