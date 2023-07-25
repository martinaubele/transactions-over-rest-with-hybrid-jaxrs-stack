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

import sample.rs.service.api.TestService1;

@Path("/test1")
@Service
@Transactional
public class TestService1Impl implements TestService1 {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test1() {
		return "test1";
	}
	
	@GET
	@Path("/callbackFromTestService3")
	@Produces(MediaType.TEXT_PLAIN)
	public String callbackFromTestService3() {
		
		Client client = newClient().register(TransactionProvider.class).register(JacksonJsonProvider.class).register(ParticipantsProvider.class).register(TransactionAwareRestClientFilter.class);

		WebTarget target2 = client.target("http://localhost:8082/transactions/");
		// Call Test2
		String response2 = target2.path("/test2").request().accept(MediaType.TEXT_PLAIN).get(String.class);

		
		return "callbackFromTestservice3 finished";
	}
}