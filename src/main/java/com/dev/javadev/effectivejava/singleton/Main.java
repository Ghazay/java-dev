package com.dev.javadev.effectivejava.singleton;

public class Main {
    public void foo(){
        MySingleton instance = MySingleton.INSTANCE;
        instance.doSomething();

        // plus concis
        MySingleton2 singleton2 = MySingleton2.INSTANCE;
        singleton2.doSomething();
    }
}
