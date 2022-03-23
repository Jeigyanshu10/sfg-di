package com.anshu.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile({"ESP","default"})
//@Service("i18nService")
public class I18nSpanishService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Monda : Espanyol";
    }
}
