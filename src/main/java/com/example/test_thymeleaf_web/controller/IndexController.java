package com.example.test_thymeleaf_web.controller;

import com.example.test_thymeleaf_web.bean.Account;
import com.example.test_thymeleaf_web.bean.City;
import com.example.test_thymeleaf_web.bean.User;
import com.example.test_thymeleaf_web.service.AccountService;
import com.example.test_thymeleaf_web.service.CityService;
import com.example.test_thymeleaf_web.service.impl.AccountServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

        @Autowired
        JdbcTemplate jdbcTemplate;

        @Autowired
        AccountService accountService;

        @Autowired
        CityService cityService;

        //@Autowired
        StringRedisTemplate stringRedisTemplate;

        @ResponseBody
        @PostMapping("/city")
        public City saveCity(City city){
            cityService.saveCity(city);
            return city;
        }


        @ResponseBody
        @GetMapping("/city")
        public City getCityById(@RequestParam("id") Long id){
           return cityService.getById(id);
        }

        @ResponseBody
        @GetMapping("/acct")
        public Account getById(@RequestParam("id") Long id){


            return accountService.getAcctByid(id);
        }

        @ResponseBody
        @GetMapping("/sql")
        public String queryFromDb(){
            Long aLong = jdbcTemplate.queryForObject("select count(*) from Test",Long.class);
            return aLong.toString();
        }

        //?????????
        @GetMapping(value = {"/","/login"})
        public String loginPage(){

            return "login";
        }

        @PostMapping("/login")
        public String main(User user, HttpSession session , Model model){

            if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){

                //????????????????????????????????????
                session.setAttribute("loginUser",user);

            }
            else{
                model.addAttribute("msg","??????????????????");

                return "login";
            }


            //?????????????????????????????????????????????????????????
            //???????????????????????????/index.html    ??????????????????????????????????????????index
            return "redirect:/index.html";
        }

        @GetMapping("/index.html")
        public String indexPage(HttpSession session,Model model){

            log.info("??????????????????{}","indexPage");
//            //????????????????????????????????????
//            Object loginUser = session.getAttribute("loginUser");
//            if(loginUser !=null){
//                return "index";
//            }
//            else {
//                //??????????????????
//                model.addAttribute("msg","??????????????????");
//            }

            //???????????? ???????????????????????????????????????????????????
//            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
//
//            String s = opsForValue.get("/index.html");
//            String s1 = opsForValue.get("/sql");
//
//            model.addAttribute("indexCount",s);
//            model.addAttribute("sqlCount",s1);

            return "index";
        }

         @GetMapping("/index_alt.html")
          public String index_alt_Page(HttpSession session,Model model){


             return "index_alt";
         }

}
