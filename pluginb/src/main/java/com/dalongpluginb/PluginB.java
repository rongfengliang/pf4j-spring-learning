package com.dalongpluginb;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PluginB extends SpringPlugin {
    public PluginB(PluginWrapper wrapper) {
        super(wrapper);
    }
    @Override
    protected ApplicationContext createApplicationContext() {
        ApplicationContext applicationContextRoot  = ((SpringPluginManager)getWrapper().getPluginManager()).getApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.setParent(applicationContextRoot);
        applicationContext.register(PluginBConfig.class);
        applicationContext.refresh();
        return applicationContext;
    }
}
