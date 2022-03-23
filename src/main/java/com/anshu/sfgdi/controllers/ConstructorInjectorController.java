package com.anshu.sfgdi.controllers;

import com.anshu.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectorController {


    private final GreetingService greetingService;

    public ConstructorInjectorController(@Qualifier("constructorInjectedGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }

}
