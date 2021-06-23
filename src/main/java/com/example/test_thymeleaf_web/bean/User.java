package com.example.test_thymeleaf_web.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor//全无参构造器
@Data
@TableName("user")// 与数据库中指定的表 进行数据映射
public class User {
/**
 * 所有属性都应该在数据库中
 * */
    @TableField(exist = false) //使其数据失效，就不会与数据库中缺少该数据，而产生冲突
    public String userName;
    @TableField(exist = false)
    public String password;

    //以下是数据库字段s
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
