package com.example.test_thymeleaf_web.mapper;

import com.example.test_thymeleaf_web.bean.Account;
import org.apache.ibatis.annotations.Mapper;

//@Mapper //Mapper接口
public interface AccountMapper {

    public Account getAcct(Long id);
}
