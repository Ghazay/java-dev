package com.dev.javadev.effectivejava.statics;


class Main {
    private String value;
    private Integer value2;

    Main(String value) {
        this.value = value;
    }

    Main(Integer value) {
        this.value2 = value;
    }

    public static void myStatic(){
        System.out.println("toto");
    }
}