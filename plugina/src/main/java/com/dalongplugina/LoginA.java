package com.dalongplugina;

import com.dalong.UserLogin;
import org.pf4j.Extension;

@Extension
public class LoginA implements UserLogin {
    @Override
    public String token(String name, String password) {
        System.out.println(this.getClass().getClassLoader().toString());
        return  String.format("LoginA %s-%s",name,password);
    }
}
