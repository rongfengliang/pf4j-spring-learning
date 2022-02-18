/*
 * Copyright (C) 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dalong;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Decebal Suiu
 */
@Configuration
public class SpringConfiguration {

    @Bean
    @Lazy
    public SpringPluginManager pluginManager() {
        return new SpringPluginManager();
    }
    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://mysq2l:3306?useLocalSessionState=true&characterEncoding=UTF-8&serverTimezone=CTT");
        config.setUsername("root");
        config.setPassword("admin22");
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return  new JdbcTemplate(dataSource());
    }
}
