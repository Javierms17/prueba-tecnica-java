package quarkusApi;


import businessLogic.FiboLogic;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;



@Path("/fibo")
public class Fibonacci {
	
    @GET
    @Path("/{pos}")
    public long fibo(@PathParam("pos")int pos) {
    	return FiboLogic.resolveFibo(pos);
	}
}
