package sample.rs.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Path("/test1")
@Service
public interface TestService1 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String test1();

    
    @GET
    @Path("/callbackFromTestService3")
    @Produces(MediaType.TEXT_PLAIN)
    String callbackFromTestService3();
}
