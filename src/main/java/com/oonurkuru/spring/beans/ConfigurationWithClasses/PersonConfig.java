package com.oonurkuru.spring.beans.ConfigurationWithClasses;

/**
 * Created by Onur Kuru on 17.7.2017.
 */

import com.oonurkuru.spring.beans.InjectingCollection.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class PersonConfig {

    @Bean
    public Person person() {
        Person person = new Person();

        person.setFollowers(Arrays.asList("Ahmet", "Mehmet", "Veli"));
        person.setProjects(Arrays.asList("JPA-BASICS", "SPRING-BASICS"));

        return person;
    }
}
