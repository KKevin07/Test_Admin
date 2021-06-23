package com.example.test_thymeleaf_web.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Deprecated  //过时注解，标注为无用
//@Configuration     注入容器才能生效，此处注释掉，是因为要引入更方便的第三方依赖  starter，同样可以开启监控台等功能(经典白学ORZ)
//注： 类里的下方注解@ 为了保险，也同样注释掉
public class MyDataSoureConfig {

    //默认的自动配置是判断容器中没有才会配@ConditionalOnMissingBean(DataSource.class)
//    @ConfigurationProperties("spring.datasource")  //配置绑定，后面定义数据源，只需在配置文件里定义。
//    @Bean//自定义一个数据源，也会生效,但会覆盖默认的自动配置数据源
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();



        //此处全部注释，是因为可以在配置文件里写，（yaml配置文件里）
        //加入监控功能
//        try {
//            druidDataSource.setFilters("stat,wall");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        //druidDataSource.setMaxActive(10);//最大活跃线程数
        return druidDataSource;
    }

    /**
     * 配置druid的监控页功能
     *
     * */
//    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;
    }


    /**
     * webStatFilter 用于采集 web-jdbc 关联监控的数据
     *
     * */
//    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");//放行的请求
        return filterRegistrationBean;
    }
}
