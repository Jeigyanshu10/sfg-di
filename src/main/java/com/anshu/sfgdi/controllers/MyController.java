package com.anshu.sfgdi.controllers;

import com.anshu.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    @Autowired
    private  GreetingService greetingService;

    public String sayHello(){

        return greetingService.sayGreeting();
    }

}
