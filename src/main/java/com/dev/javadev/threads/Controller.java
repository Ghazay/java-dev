package com.dev.javadev.threads;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class Controller {

    @RequestMapping("/")
    public String index(){
        int numOfCores = Runtime.getRuntime().availableProcessors();
        int numOfThreads = Math.max(numOfCores / 2, 1);
        System.out.println(numOfThreads);

        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);
        MyThread myThread = new MyThread("Jerome");
        executor.execute(myThread);
        MyThread myThread2 = new MyThread("Another");
        executor.execute(myThread2);

        return "Exécution depuis " + System.getenv("tki");
    }
}
