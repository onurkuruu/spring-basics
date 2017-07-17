package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import com.oonurkuru.spring.beans.InjectingCollection.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Onur Kuru on 17.7.2017.
 */

/**
 * Eğer bean alanları List, Set, Array gibi tipinde bir değişkene sahipse xml ayar dosyası içerisinde bu değişkene atama
 * yapılabilir. kullanım için collection.xml ayar dosyası incelenebilir.
 */
@ExampleClassCode(classCode = "6")
public class InjectingCollection implements Example {

    @Override
    public void runExample() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collection.xml");
        Person person = (Person) applicationContext.getBean("person");

        System.out.println("Followers");
        System.out.println(person.getFollowers());

        System.out.println("Projects");
        System.out.println(person.getProjects());
    }
}
