package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import com.oonurkuru.spring.beans.BeanInheritance.ChildBean;
import com.oonurkuru.spring.beans.BeanInheritance.SuperBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Onur Kuru on 17.7.2017.
 */

/**
 * Spring Bean sınıfları arasında, Java sınıfları arasında olduğu gibi kalıtım alınabilir. Bir süper bean oluşturarak
 * değişkenlerine atama yapıp child beanler için  parent sınıf olarak bu sınıf gösterilebilir.
 *
 * Bir beani soyut olarak da belirtebiliriz. Bu beanlerin bir örneği oluşturulamaz sadece diğer beanler için şablon oluşturur.
 */
@ExampleClassCode(classCode = "4")
public class SpringBeanInheritance implements Example {

    @Override
    public void runExample() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-inheritance.xml");

        SuperBean superBean = (SuperBean) applicationContext.getBean("superBean");
        ChildBean childBean = (ChildBean) applicationContext.getBean("childBean");

        String output = "Super Bean" +
                " Var 1: " +
                superBean.getVar1() +
                " Var 2:" +
                superBean.getVar2() +
                "\n" +
                "Child Bean" +
                " Var 1: " +
                childBean.getVar1() +
                " Var 2:" +
                childBean.getVar2() +
                " Var 3:" +
                childBean.getVar3();

        System.out.print(output);
    }
}
