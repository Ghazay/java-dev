package com.dev.javadev.threads;

public class MyThread implements Runnable {

    private final String user;

    MyThread(String user) {
        this.user = user;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Salut " + user);
        } catch (InterruptedException ignored) {
        }
    }
}
