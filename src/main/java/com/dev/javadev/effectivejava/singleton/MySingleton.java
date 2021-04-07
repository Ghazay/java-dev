package com.dev.javadev.effectivejava.singleton;

class MySingleton {
    public static final MySingleton INSTANCE = new MySingleton();

    private MySingleton(){

    };

    public void doSomething(){

    }

    private Object readResolve(){
        return INSTANCE;
    }
}

