package com.epam.spring;

import com.epam.spring.annotations.InjectRandomInt;
import com.epam.spring.annotations.PostProxy;
import com.epam.spring.annotations.Profiling;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("3'rd phase");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
