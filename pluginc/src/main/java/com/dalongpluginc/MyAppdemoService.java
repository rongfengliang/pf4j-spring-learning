package com.dalongpluginc;

import com.dalong.UserLogin;

import java.util.List;
import java.util.function.Consumer;

public class MyAppdemoService {

    private final List<UserLogin> loginList;
    public MyAppdemoService(List<UserLogin> loginList){
        this.loginList=loginList;
    }
    public  void print(){

        loginList.forEach(new Consumer<UserLogin>() {
            @Override
            public void accept(UserLogin userLogin) {
                System.out.println(userLogin.getClass().getClassLoader().toString()+userLogin.getClass().getName()+" bean init "+userLogin.token("dalong","deoapp"));
            }
        });
    }
}
