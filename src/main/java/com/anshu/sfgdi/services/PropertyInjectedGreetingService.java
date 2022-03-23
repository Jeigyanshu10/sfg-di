package com.anshu.sfgdi.services;

import org.springframework.stereotype.Service;


public class PropertyInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello from Property service";
    }
}
