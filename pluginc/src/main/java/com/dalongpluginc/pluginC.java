package com.dalongpluginc;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class pluginC extends SpringPlugin {
    public pluginC(PluginWrapper wrapper) {
        super(wrapper);
    }
    @Override
    protected ApplicationContext createApplicationContext() {
        ApplicationContext applicationContextRoot  = ((SpringPluginManager)getWrapper().getPluginManager()).getApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.setParent(applicationContextRoot);
        applicationContext.register(PluginCConfig.class,ConfigurationPropertiesBindingPostProcessor.class);
        applicationContext.refresh();
        MyConfigProperties myConfigProperties= applicationContext.getBean(MyConfigProperties.class);
        System.out.println("from pluginc conf:"+myConfigProperties.toString());
        return applicationContext;
    }
}
