package quarkusApi;


import businessLogic.FiboLogic;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;



@Path("/fibo")
@Transactional
public class Fibonacci {
	
	@Inject
	FiboLogic fiboLogic;
	
    @GET
    @Path("/{pos}")
    public long fibo(@PathParam("pos")int pos) {
    	return fiboLogic.resolveFibo(pos);
	}
}
