package com.dalongpluginc;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties(prefix = "demoapp")
@Configuration
@PropertySource(name ="dalongdemo",value = "classpath:app.yaml",factory = YamlPropertySourceFactory.class)
public class MyConfigProperties {
    private   String name;
    private   int age;
    private String demoname;

    public String getDemoname() {
        return demoname;
    }

    public void setDemoname(String demoname) {
        this.demoname = demoname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyConfigProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", demoname='" + demoname + '\'' +
                '}';
    }
}
