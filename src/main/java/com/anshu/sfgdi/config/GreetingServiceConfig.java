package com.anshu.sfgdi.config;

import com.anshu.sfgdi.controllers.PropertyInjectedController;
import com.anshu.sfgdi.datasource.FakeDataSource;
import com.anshu.sfgdi.repositories.EnglishGreetingRepository;
import com.anshu.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.anshu.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource myFakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}")String jdbcurl){
        FakeDataSource fakeDataSource=new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishService(englishGreetingRepository);
    }

    @Profile("ES")
    @Bean("i18nService")
    I18nSpanishService I18nSpanishService(){
        return new I18nSpanishService();
    }

    @Primary
    @Bean
    PrimaryServiceBean primaryServiceBean(){
        return new PrimaryServiceBean();
    }

    @Bean
    ConstructorInjectedGreetingService constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    PropertyInjectedController propertyInjectedController(){
        return new PropertyInjectedController();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
