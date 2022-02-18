package com.dalongplugina;

import com.dalong.UserLogin;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PluginAConfig implements ApplicationContextAware {
    public   static ApplicationContext applicationContext;

    @Bean
    public UserLogin userLogin(){
        return new LoginA();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;

    }
}
