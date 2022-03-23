package com.anshu.sfgdi.controllers;

import com.anshu.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectorController {

    @Qualifier("setterInjectedGreetingService")
    @Autowired
    private GreetingService greetingService;

    public String getGreetingService() {

        return greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {

        this.greetingService = greetingService;
    }
}
