package com.dev.javadev.threads;

import com.dev.javadev.redis.MyJedis;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDevApplication {

	public static void main(String[] args) {
		MyJedis myJedis = new MyJedis();
		myJedis.main();
	}

}
