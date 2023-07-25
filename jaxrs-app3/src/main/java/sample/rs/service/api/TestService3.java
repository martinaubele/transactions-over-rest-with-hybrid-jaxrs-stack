package sample.rs.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Path("/test3")
@Service
public interface TestService3 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String test3();

}
