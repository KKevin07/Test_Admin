package com.example.test_thymeleaf_web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Stream;

@DisplayName("嵌套测试")
public class Test_AStack_Demo {
    Stack<Object> stack;


    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterized(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("参数化测试2")
    @MethodSource("stringProvider")
    void testParameterizedFunction(String i){
        System.out.println(i);
    }



    static Stream<String> stringProvider(){
        return Stream.of("apple","banana","jiutianke");
    }


    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
            new Stack<>();

            //嵌套测试情况下，外层的Test不能驱动内层的  @BeforeEach  、 @BeforeAll 、@AfterEach  、 @AfterAll之类的方法（提前、之后）运行
            assertNotNull(stack);
        }
    @Nested //代表当前测试为嵌套测试
    @DisplayName("when new")


    class WhenNew {

     @BeforeEach
      void createNewStack() {
             stack = new Stack<>();
      }

      @Test
      @DisplayName("is empty")
      void isEmpty() {
             assertTrue(stack.isEmpty());
      }

      @Test
      @DisplayName("throws EmptyStackException when popped")
      void throwsExceptionWhenPopped() {
             assertThrows(EmptyStackException.class, stack::pop);
      }

      @Test
      @DisplayName("throws EmptyStackException when peeked")
      void throwsExceptionWhenPeeked() {
            assertThrows(EmptyStackException.class, stack::peek);  // stack::peek 查看栈中第一个元素
             }
      @Nested //代表当前测试为嵌套测试
      @DisplayName("after pushing an element")
        class AfterPushing {

         String anElement = "an element";

         @BeforeEach
        void pushAnElement() {
                stack.push(anElement);
                 }

         @Test
        @DisplayName("it is no longer empty")
        void isNotEmpty() {
                assertFalse(stack.isEmpty());
                }
          //嵌套测试情况下，内层的Test可以驱动  外层的  @BeforeEach  、 @BeforeAll 、@AfterEach  、 @AfterAll之类的方法

         @Test
        @DisplayName("returns the element when popped and is empty")
        void returnElementWhenPopped() {
                assertEquals(anElement, stack.pop());
                 assertTrue(stack.isEmpty());
               }

         @Test
        @DisplayName("returns the element when peeked but remains not empty")
        void returnElementWhenPeeked() {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
                 }
}
}


}
