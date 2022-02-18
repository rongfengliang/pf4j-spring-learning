package com.dalongpluginb;

import com.dalong.UserLogin;
import org.pf4j.Extension;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Extension
public class LoginB implements UserLogin {
    @Autowired
    private   MyDemo myDemo;
    @Autowired
    private  JdbcTemplate jdbcTemplate;
    @Override
    public String token(String name, String password) {
        System.out.println("LoginB"+this.getClass().getClassLoader().toString()+"from pluginb");
        System.out.println("jdbcTemplate"+jdbcTemplate.getClass().getClassLoader()+"from classloader b");
//        JdbcTemplate jdbcTemplate= PluginBConfig.applicationContext.getParent().getBean("jdbcTemplate",JdbcTemplate.class);
        System.out.println("LoginB"+this.getClass().getClassLoader().toString()+"size:========"+ BeanFactoryUtils.beanNamesForTypeIncludingAncestors(PluginBConfig.applicationContext,UserLogin.class).length);
        Arrays.stream(BeanFactoryUtils.beanNamesForTypeIncludingAncestors(PluginBConfig.applicationContext,UserLogin.class)).collect(Collectors.toList()).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("LoginB-----items----"+s);
            }
        });
        return jdbcTemplate.queryForList("SELECT  * from information_schema.TABLES").get(0).toString();
//        return  myDemo.demoApp("name",password);
    }
}
