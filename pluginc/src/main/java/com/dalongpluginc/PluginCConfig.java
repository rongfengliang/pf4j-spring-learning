package com.dalongpluginc;

import com.dalong.UserLogin;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import java.util.List;

@Configuration
public class PluginCConfig implements ApplicationContextAware {

    public   static ApplicationContext applicationContext;
    @Bean
    public  MyDemo myDemo(){
        return  new MyDemo();
    }
    @Bean(initMethod = "print")
    public  MyAppdemoService myAppdemoService(List<UserLogin> loginList){
        return  new MyAppdemoService(loginList);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
