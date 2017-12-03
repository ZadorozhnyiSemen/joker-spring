package com.epam.spring;

import com.epam.spring.robots.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
