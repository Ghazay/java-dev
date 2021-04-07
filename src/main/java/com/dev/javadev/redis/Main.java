package com.dev.javadev.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Main {

	public static void main(String[] args) {
		MyJedis myJedis = new MyJedis();
		myJedis.main();
	}
}
