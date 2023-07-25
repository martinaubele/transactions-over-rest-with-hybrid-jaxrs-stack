package com.atomikos.jaxrshibernate.service;

import static javax.ws.rs.client.ClientBuilder.newClient;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.atomikos.remoting.jaxrs.TransactionAwareRestClientFilter;
import com.atomikos.remoting.taas.TransactionProvider;
import com.atomikos.remoting.twopc.ParticipantsProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import sample.rs.service.api.TestService3;

@Path("/test3")
@Service
@Transactional
public class TestService3Impl implements TestService3 {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test3() {
		Client client = newClient().register(TransactionProvider.class).register(JacksonJsonProvider.class).register(ParticipantsProvider.class).register(TransactionAwareRestClientFilter.class);

		WebTarget target1 = client.target("http://localhost:8080/transactions/");
		
		// Call test1/callbackFromTestService3
		// this will do a call to TestService2
		target1.path("/test1/callbackFromTestService3").request().accept(MediaType.TEXT_PLAIN).get(String.class);

		// Now call test1
		// This will lead to a NullPointerException because the cascadeList will be overridden		
		target1.path("/test1").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		return "test3";

	}
}