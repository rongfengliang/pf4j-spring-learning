package com.dalongpluginc;

import org.hashids.Hashids;

public class MyDemo {
    Hashids hashids = new Hashids("demo");
    public  String demoApp(String name,String password){
        return String.format("%s--%s====%s- service demo",name,password,hashids.encode(1000));
    }
}
