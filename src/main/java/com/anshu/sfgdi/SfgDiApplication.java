package com.anshu.sfgdi;

import com.anshu.sfgdi.controllers.*;
import com.anshu.sfgdi.datasource.FakeDataSource;
import com.anshu.sfgdi.services.PrototypeBean;
import com.anshu.sfgdi.services.SingletonBean;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.anshu.sfgdi","com.anshu.sfgdi.config"})
public class SfgDiApplication {

	public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController)ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController controller = (MyController) ctx.getBean("myController");
		System.out.println("--------Controller");
		System.out.println(controller.sayHello());

		System.out.println("-------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController)ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------- Setter");
		SetterInjectorController setterInjectorController = (SetterInjectorController)ctx.getBean("setterInjectorController");
		System.out.println(setterInjectorController.getGreetingService());

		System.out.println("-------- Constructor");
		ConstructorInjectorController constructorInjectorController = (ConstructorInjectorController)ctx.getBean("constructorInjectorController");
		System.out.println(constructorInjectorController.getGreeting());

		System.out.println("----Bean Scopes----");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

	}

}
