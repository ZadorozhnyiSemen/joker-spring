package com.epam.spring;

public class TerminatorQuoter implements Quoter {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {

    }
}
