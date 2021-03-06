package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import com.oonurkuru.spring.beans.InnerBean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Onur Kuru on 17.7.2017.
 */

/**
 * Inner beanler java inner sınıflarından biraz farklıdır. Bir beaninin herhangi bir değişkeninin tipi kullanıcı tanımlı
 * sınıf ise bu alana atama yapmak için inner beanler kullanılır. Kullanım örneği olarak inner-bean.xml ayar dosyası incelenebilir.
 */
@ExampleClassCode(classCode = "5")
public class InnerBean implements Example {
    @Override
    public void runExample() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("inner-bean.xml");
        Person person = (Person) applicationContext.getBean("person");

        System.out.println("Phone Number : " + person.getPhone().getPhoneNumber());
    }
}
