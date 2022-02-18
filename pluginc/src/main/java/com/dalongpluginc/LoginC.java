package com.dalongpluginc;

import com.dalong.UserLogin;
import org.hashids.Hashids;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

@Extension
public class LoginC implements UserLogin {
    @Autowired
    private   MyDemo myDemo;
    @Autowired
    @Lazy
    private  JdbcTemplate jdbcTemplate;
    Hashids hashids = new Hashids("demo");
    @Override
    public String token(String name, String password) {
        System.out.println("Loginc"+this.getClass().getClassLoader().toString()+"from pluginc");
        System.out.println("jdbcTemplate"+jdbcTemplate.getClass().getClassLoader()+"from classloader c");
//        JdbcTemplate jdbcTemplate2= PluginCConfig.applicationContext.getParent().getBean("jdbcTemplate",JdbcTemplate.class);
        return jdbcTemplate.queryForList("SELECT  * from information_schema.SCHEMATA s ").get(0).toString()+"from pluginc"+hashids.encode(2000);
    }
}
