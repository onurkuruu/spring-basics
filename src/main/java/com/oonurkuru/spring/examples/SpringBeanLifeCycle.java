package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Onur Kuru on 16.7.2017.
 */

/**
 * SpringBean Sınıfının implemente ettiği InitializingBean ve DisposableBean arayüzleri sayesinde bean oluşturulma ve yok
 * edilme zamanında callback metotları ile işlem yapılabilir. Aynı işlem xml üzerinden init-method ve destroy-method
 * parametreleri ile de sağlanabilir.
 */
@ExampleClassCode(classCode = "3")
public class SpringBeanLifeCycle implements Example {
    @Override
    public void runExample() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-life-cycles.xml");
        applicationContext.start();
        applicationContext.stop();
    }
}
