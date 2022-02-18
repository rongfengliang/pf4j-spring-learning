package com.dalong;

import org.pf4j.PluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Api {
    @Autowired
    private PluginManager pluginManager;
    @Autowired
    private List<UserLogin> userLoginList;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/demoapp")
    public Object get() {
        return pluginManager.getPlugins().stream().map(item -> item.getPluginId()).collect(Collectors.toList());
    }

    @GetMapping(value = "/login")
    public Object login() {
       return userLoginList.stream().map(item -> item.token("dalong", "demoapp")).collect(Collectors.toList());
    }
    @GetMapping(value ="/sql")
    public  String login2(){
        return jdbcTemplate.queryForList("SELECT  * from information_schema.`COLUMNS`").get(0).toString();
    }
    @GetMapping(value ="/beans")
    public  Object beans(){
        return  Appliction.applicationContextGLobal.getBeanDefinitionNames();
    }
}
