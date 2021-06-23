package com.example.test_thymeleaf_web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test_thymeleaf_web.bean.User;
import com.example.test_thymeleaf_web.exception.UserTooManyException;
import com.example.test_thymeleaf_web.mapper.UserMapper;
import com.example.test_thymeleaf_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    /**
     *
     * @param a   （请求中带参数）这里的错误返回码，不带请求参数或者参数类型不对   返回-->400 : Bad Request 一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")  //加入@RequestParam("a") 后就要在路径中加入参数  ？a=xx，否则报错为参数缺失相关异常处理
    public String basic_table(@RequestParam("a") int a){
//        int i = 10/0;      可以测试  数字除零异常的异常处理，现在恢复默认
        int i=a;  //处理传参 a，否则异常处理会报错，说a未被利用
        return "Tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表格内容的遍历
        List<User> users = Arrays.asList(new User("zhangsan","123456",1L,"XXX",18,"666"),
        new User("lisi","123444",2L,"XXX",18,"666"),
        new User("wangwu","123455",3L,"XXX",18,"666"),
        new User("jiutianke","1091789267",4L,"XXX",18,"666"));
        model.addAttribute("users",users);
        //要用数据库的用户字段，暂时修改这里的全参构造，

        if (users.size()>100){   //用户数量太多的异常处理，超出限制则报错，由UserTooManyException处理，现在恢复原来页面，改为100用户限制
            throw new UserTooManyException();
        }
        return "Tables/dynamic_table";
    }



    @GetMapping("responsive_table")
    public String responsive_table(){
        return "Tables/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){
        return ("Tables/editable_table");
    }

    @Autowired
    UserMapper userMapper;
    @GetMapping("/city_table")
    public String city_table(Model model){
        //表格内容的遍历

        List<User> users = Arrays.asList(userMapper.selectById(1L),
                userMapper.selectById(2L),
                userMapper.selectById(3L),
                userMapper.selectById(4L),
                userMapper.selectById(5L));
        model.addAttribute("users",users);

        return "Tables/city_table";
    }

    @Autowired
    UserService userService;
    @GetMapping("/new_city_table")
    public String new_city_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //表格内容的遍历

        List<User> list= userService.list();
       // model.addAttribute("users",list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果
        Page<User> page = userService.page(userPage, null);   //第一个是对象，第二个是查询条件
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();

        model.addAttribute("page",page);

        return "Tables/new_city_table";
    }

    /**
     * 删除 按钮
     * */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/new_city_table";
    }

}
