package com.example.test_thymeleaf_web;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
@SpringBootTest
@DisplayName("Junit5功能测试类")
public class Junit5_Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testassumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("11111111111");


    }


    /**
     * 断言：前面断言失败，后面的代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(3, 2);
        assertEquals(5,cal,"业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    int cal(int i,int j){
        return i+j;
    }

    @Test
    @DisplayName("array assertion")
    void array(){
        assertArrayEquals(new int[]{1,2}, new int[] {1,2},"数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    void all(){
        /**
         * 所有断言全部需要成功（才能继续进行程序）
         * 用来同时断言多个测试，不会因为前面断言失败而导致后面的断言不执行
         */
        assertAll("test",
                ()-> assertTrue(true && true,"结果不为true"),
                ()-> assertEquals(1,2,"结果不是1")
                );
        System.out.println("==========");
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        //判定一定出异常，并且抛出该异常。（若正常运行无异常产生，则无异常可供抛出，就会产生新的抛出异常）
        assertThrows(ArithmeticException.class,()->{int i=10/2;},"业务逻辑居然正常运行？");
    }

    @DisplayName("快速失败")//不等测试结束，直接判定为失败
    @Test
    void testFail(){
        //xxxxxxxxxx
        if(1 ==2){
        fail("测试失败");

        }
    }


    @DisplayName("测试1.注解")
    @Test
    void testDisplayName(){

        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @DisplayName("测试2.注解")
    @Test
    void testDisplayNumber(){
        System.out.println(2333);
    }

    @RepeatedTest(6)  //重复测试
    @Test
    void test_3(){
        System.out.println(6);
    }

    /**
     * 规定方法超时时间，超时则出异常
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)  //超时设置，前面是数字，后面是时间单位
    @Test
    void testTimeout() throws InterruptedException{

        Thread.sleep(400);
    }

    @BeforeEach
    void  testBeforeEach(){
        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试已结束");
    }

}
