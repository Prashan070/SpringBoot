package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductApplication {


    public static void main(String[] args) {

/*
		ApplicationContext storebox = 	SpringApplication.run(SpringUnderstandingApplication.class, args);
	    MyComponenet componenet = 	storebox.getBean(MyComponenet.class);
	    componenet.MyConstuctorMethod();
*/

        SpringApplication.run(ProductApplication.class, args);


    }

}
