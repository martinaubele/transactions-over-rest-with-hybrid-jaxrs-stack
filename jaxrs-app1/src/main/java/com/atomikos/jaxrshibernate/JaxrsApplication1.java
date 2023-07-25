package com.atomikos.jaxrshibernate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JaxrsApplication1 extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new JaxrsApplication1()
		.configure(new SpringApplicationBuilder(JaxrsApplication1.class))
		.run(args);
	}

}
