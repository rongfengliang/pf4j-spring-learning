package com.dalongpluginb;

import com.dalong.UserLogin;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

@Configuration
public class PluginBConfig implements ApplicationContextAware {

    public   static ApplicationContext applicationContext;
    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306?characterEncoding=UTF-8&serverTimezone=CTT");
        config.setUsername("admin");
        config.setPassword("admin");
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource;
    }
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
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return  new JdbcTemplate(dataSource());
    }
}
