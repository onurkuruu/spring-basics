package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import com.oonurkuru.spring.beans.ConfigurationWithClasses.PersonConfig;
import com.oonurkuru.spring.beans.InjectingCollection.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Onur Kuru on 17.7.2017.
 */

/**
 * Spring ayarları bir xml dosyasından yapılabildiği gibi bir sınıf içerisinde de yapılabilir. PersonConfig sınıfı
 * Configuration notasyonu ile işaretlenip, bu sınıfın spring için ayarların yapıldığı sınıf olduğu bildirilir.
 */
@ExampleClassCode(classCode = "7")
public class ConfigurationWithClasses implements Example {

    @Override
    public void runExample() {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);

        Person person = (Person) applicationContext.getBean("person");

        System.out.println("Followers");
        System.out.println(person.getFollowers());

        System.out.println("Projects");
        System.out.println(person.getProjects());
    }
}
