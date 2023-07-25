package com.atomikos.jaxrshibernate.service;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import sample.rs.service.api.TestService2;

@Path("/test2")
@Service
@Transactional
public class TestService2Impl implements TestService2 {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Hello2 Welcome to CXF RS Spring Boot World!!!";
	}
}