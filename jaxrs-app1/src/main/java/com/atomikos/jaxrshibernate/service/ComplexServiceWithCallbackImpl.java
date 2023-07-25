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

import sample.rs.service.api.ComplexServiceWithCallback;

@Path("/complexCall")
@Service
@Transactional
public class ComplexServiceWithCallbackImpl implements ComplexServiceWithCallback {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doComplexCall() {
		
		Client client = newClient().register(TransactionProvider.class).register(JacksonJsonProvider.class).register(ParticipantsProvider.class).register(TransactionAwareRestClientFilter.class);

		WebTarget target3 = client.target("http://localhost:8083/transactions/");
		
		// Call Test3
		// Test3 will call Test1 on this server. This will delete the cascadeList of our call to test2
		String response3 = target3.path("/test3").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		
		return "Complex call finished";
	}
	
	
	
	
	

}