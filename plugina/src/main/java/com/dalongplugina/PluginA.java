package com.dalongplugina;

import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PluginA extends SpringPlugin {
    public PluginA(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        ApplicationContext applicationContextRoot  = ((SpringPluginManager)getWrapper().getPluginManager()).getApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.setParent(applicationContextRoot);
        applicationContext.register(PluginAConfig.class);
        applicationContext.refresh();
        return applicationContext;
    }
}
