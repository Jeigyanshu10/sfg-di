package com.anshu.sfgdi.services;



public class PrimaryServiceBean implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello from primary service";
    }
}
