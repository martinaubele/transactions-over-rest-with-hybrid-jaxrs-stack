package com.atomikos.jaxrshibernate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JaxrsApplication2 extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new JaxrsApplication2()
		.configure(new SpringApplicationBuilder(JaxrsApplication2.class))
		.run(args);
	}

}
