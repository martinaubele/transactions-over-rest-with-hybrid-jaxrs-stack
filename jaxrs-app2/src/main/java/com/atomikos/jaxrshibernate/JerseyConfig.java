package com.atomikos.jaxrshibernate;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.atomikos.jaxrshibernate.service.TestService2Impl;
import com.atomikos.remoting.jaxrs.TransactionAwareRestContainerFilter;
import com.atomikos.remoting.taas.TransactionProvider;
import com.atomikos.remoting.twopc.AtomikosRestPort;
import com.atomikos.remoting.twopc.ParticipantsProvider;

@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(TransactionAwareRestContainerFilter.class);
		register(ParticipantsProvider.class);
		register(TransactionProvider.class);
		register(AtomikosRestPort.class);
		register(TestService2Impl.class);
	}
}