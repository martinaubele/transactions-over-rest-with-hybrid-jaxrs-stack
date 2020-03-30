package com.atomikos.jaxrshibernateclient.service;

import static javax.ws.rs.client.ClientBuilder.newClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atomikos.jaxrshibernate.domain.Account;
import com.atomikos.remoting.jaxrs.TransactionAwareRestClientFilter;
import com.atomikos.remoting.taas.TransactionProvider;
import com.atomikos.remoting.twopc.ParticipantsProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Service
@Transactional
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	WebTarget target;
	public PaymentService() {
		Client client = newClient().register(TransactionProvider.class).register(JacksonJsonProvider.class).register(ParticipantsProvider.class).register(TransactionAwareRestClientFilter.class);
		target = client.target("http://localhost:8080/transactions/");
		
	}
	
	public void savePaymentAndAccount(String name, Integer amount, String unique) {
		//Perform DB work
		
		Payment payment = new Payment(name, amount, unique);
		paymentRepository.save(payment);
		
		//call rest endpoint
		Account account = new Account(name);
		Account invoke = target.path("/account").request().accept(MediaType.APPLICATION_JSON).buildPost(Entity.entity(account, MediaType.APPLICATION_JSON)).invoke(Account.class);
		System.out.println(invoke.getId());
		
		if ("error".equals(name)) {
			throw new RuntimeException("Simulated error");
		}
	}
}
