package com.dalongplugina;

import com.dalong.UserLogin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PluginAConfig {

    @Bean
    public UserLogin userLogin(){
        return new LoginA();
    }
}
