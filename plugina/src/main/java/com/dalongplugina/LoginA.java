package com.dalongplugina;

import com.dalong.UserLogin;
import org.pf4j.Extension;
import org.springframework.beans.factory.BeanFactoryUtils;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Extension
public class LoginA implements UserLogin {
    @Override
    public String token(String name, String password) {
        System.out.println(this.getClass().getClassLoader().toString()+"from plugina");
        System.out.println("LoginA"+this.getClass().getClassLoader().toString()+"size:========"+ BeanFactoryUtils.beanNamesForTypeIncludingAncestors(PluginAConfig.applicationContext,UserLogin.class).length);
        Arrays.stream(BeanFactoryUtils.beanNamesForTypeIncludingAncestors(PluginAConfig.applicationContext,UserLogin.class)).collect(Collectors.toList()).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("LoginA-----items----"+s);
            }
        });
        return  String.format("LoginA %s-%s",name,password);
    }
}
