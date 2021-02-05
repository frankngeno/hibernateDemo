package com.grl.hibernateDemo.pickOrderHandler;

public class PickOrderNotFoundException extends RuntimeException {
    public PickOrderNotFoundException(Long id) {
        super("Could not find new pick orders " + id);
    }
}
