package com.dalongpluginb;

import com.dalong.UserLogin;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Extension
public class LoginB implements UserLogin {
    @Autowired
    private   MyDemo myDemo;
    @Autowired
    private  JdbcTemplate jdbcTemplate;
    @Override
    public String token(String name, String password) {
        System.out.println(this.getClass().getClassLoader().toString());
//        JdbcTemplate jdbcTemplate= PluginBConfig.applicationContext.getParent().getBean("jdbcTemplate",JdbcTemplate.class);
        return jdbcTemplate.queryForList("SELECT  * from information_schema.TABLES").get(0).toString();
//        return  myDemo.demoApp("name",password);
    }
}
