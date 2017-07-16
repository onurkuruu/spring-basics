package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import com.oonurkuru.spring.beans.SpringHelloWorld.SpringHelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Onur Kuru on 16.7.2017.
 */

/**
 * spring-hello-world.xml içerisinde tanımlı olan ayarlar ClassPathXmlApplicationContext sınıfı tarafından okunarak
 * yüklenir. spring-hello-world.xml içerisinde tanımlı olan beanler getBean() metotu ile alınabilir.
 * spring-hello-world.xml ayar dosyası içerisinde SpringHelloWorld sınıfına ait alanlar atanabilir.
 * Bu örnekte spring-hello-world.xml içerisinde bir bean oluşturarak SpringHelloWorld sınıfının message alanına değer atadık
 * Daha sonra bu beani alarak değeri ekrana yazdırdık.
 *
 */
@ExampleClassCode(classCode = "1")
public class SpringHelloWorldExample implements Example {

    public void runExample() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-hello-world.xml");
        com.oonurkuru.spring.beans.SpringHelloWorld.SpringHelloWorld springHelloWorld = (com.oonurkuru.spring.beans.SpringHelloWorld.SpringHelloWorld) context.getBean("springHelloWorld");

        System.out.println(springHelloWorld.getMessage());
    }
}
