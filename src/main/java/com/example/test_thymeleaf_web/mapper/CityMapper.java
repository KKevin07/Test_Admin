package com.example.test_thymeleaf_web.mapper;

import com.example.test_thymeleaf_web.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {

    //纯注解方式  代替在xml中写sql配置   适合sql少的情况
    @Select("select * from city where id=#{id}")
    public City getById(Long id);

    //sql语句过长过多时，可以使用xml配置文件来配置，  （即两种方式都可使用，混合版）
    @Insert( "insert into city(name,state,country) values(#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")   //@Insert的配置项
    public void insert(City city);

}
