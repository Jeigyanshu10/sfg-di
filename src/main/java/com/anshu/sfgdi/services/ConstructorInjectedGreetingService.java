package com.anshu.sfgdi.services;

import org.springframework.stereotype.Service;


public class ConstructorInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello from Constructor service";
    }
}
