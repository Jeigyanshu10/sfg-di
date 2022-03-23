package com.anshu.sfgdi.services;

import com.anshu.sfgdi.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("EN")
//@Service("i18nService")
public class I18nEnglishService implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello world : English";
    }
}
