package com.oonurkuru.spring.beans.BeanLifeCycles;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by Onur Kuru on 16.7.2017.
 */
public class SpringBean implements InitializingBean, DisposableBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean has been created");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean has been deleted");
    }
}
