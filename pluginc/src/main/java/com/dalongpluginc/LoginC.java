package com.dalongpluginc;

import com.dalong.UserLogin;
import org.hashids.Hashids;
import org.pf4j.Extension;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Extension
public class LoginC implements UserLogin {
    @Autowired
    private   MyDemo myDemo;
    @Autowired
    @Lazy
    private  JdbcTemplate jdbcTemplate;
    Hashids hashids = new Hashids("demo");

    @Autowired
    private Environment env;
    @Override
    public String token(String name, String password) {
        String myConfigProperties= env.getProperty("age");
        System.out.println(env.toString());
        System.out.println("from pluginc conf env:"+myConfigProperties.toString());
        System.out.println("Loginc"+this.getClass().getClassLoader().toString()+"from pluginc");
        System.out.println("jdbcTemplate"+jdbcTemplate.getClass().getClassLoader()+"from classloader c");
        System.out.println("LoginC"+this.getClass().getClassLoader().toString()+"size:========"+ BeanFactoryUtils.beanNamesForTypeIncludingAncestors(PluginCConfig.applicationContext,UserLogin.class).length);
        Arrays.stream(BeanFactoryUtils.beanNamesForTypeIncludingAncestors(PluginCConfig.applicationContext,UserLogin.class)).collect(Collectors.toList()).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("LoginC-----items----"+s);
            }
        });
        return jdbcTemplate.queryForList("SELECT  * from information_schema.SCHEMATA s ").get(0).toString()+"from pluginc"+hashids.encode(2000);
    }
}
