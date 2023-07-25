package com.atomikos.jaxrshibernate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JaxrsApplication3 extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new JaxrsApplication3()
		.configure(new SpringApplicationBuilder(JaxrsApplication3.class))
		.run(args);
	}

}
