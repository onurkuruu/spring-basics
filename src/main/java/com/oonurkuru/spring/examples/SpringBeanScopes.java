package com.oonurkuru.spring.examples;

import com.oonurkuru.spring.annotations.ExampleClassCode;
import com.oonurkuru.spring.beans.BeanScopes.PrototypeBean;
import com.oonurkuru.spring.beans.BeanScopes.SingletonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Onur Kuru on 16.7.2017.
 */

/**
 * bean-scopes.xml içerisinde tanımlı olan 2 adet beanimiz var. singletonBean'nin scope değeri singleton olarak belirlenmiştir
 * prototypeBean'nin scope değeri prototype olarak belirlenmiştir. Scope değerinin singleton olması ilgili beanin sadece
 * bir defa oluşturulacağı anlamına gelmektedir. Prototype değeri ise bean her istendiğinde yeni bir örneği geri döndürülecektir.
 *
 * Örneğimizde singleton bean nesnesimi aldıktan sonra değerini değiştiriyoruz. Beani tekrar aldığımızda değerin aynı kaldığını
 * görürüz. Prototype bean için değeri değiştirip tekrar beani aldığımızda değerinin sıfırlandığını görürüz.
 */
@ExampleClassCode(classCode = "2")
public class SpringBeanScopes implements Example {
    @Override
    public void runExample() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scopes.xml");

        SingletonBean singletonBean = (SingletonBean) context.getBean("singletonBean");
        singletonBean.setVar("Singleton Bean");
        System.out.println(singletonBean.getVar());

        singletonBean = (SingletonBean) context.getBean("singletonBean");
        System.out.println(singletonBean.getVar());

        PrototypeBean prototypeBean = (PrototypeBean) context.getBean("prototypeBean");
        prototypeBean.setVar("Prototype Bean");
        System.out.println(prototypeBean.getVar());

        prototypeBean = (PrototypeBean) context.getBean("prototypeBean");
        System.out.println(prototypeBean.getVar());
    }
}
