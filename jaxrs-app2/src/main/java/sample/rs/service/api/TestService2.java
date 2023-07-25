package sample.rs.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Path("/test2")
@Service
public interface TestService2 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String test();

}
