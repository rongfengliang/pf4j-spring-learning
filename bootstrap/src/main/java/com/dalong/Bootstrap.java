package com.dalong;

import org.pf4j.Extension;
import org.springframework.beans.factory.BeanFactoryUtils;

@Extension
public class Bootstrap implements UserLogin {
    @Override
    public String token(String name, String password) {
        System.out.println(this.getClass().getClassLoader().toString()+"from Bootstrap");
//        System.out.println("Bootstrap"+this.getClass().getClassLoader().toString()+"size:========"+ BeanFactoryUtils.beanNamesForTypeIncludingAncestors(Appliction.applicationContextGLobal,UserLogin.class).length);
        return  String.format("Bootstrap %s-%s",name,password);
    }
}
