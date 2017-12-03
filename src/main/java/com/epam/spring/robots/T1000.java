package com.epam.spring.robots;

public class T1000 extends TerminatorQuoter implements Quoter {
    @Override
    public void sayQuote() {
        System.out.println("я жидкий :D");
    }
}
