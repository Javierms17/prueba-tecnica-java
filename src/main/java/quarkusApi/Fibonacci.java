package quarkusApi;


import java.util.List;

import businessLogic.FiboLogic;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import models.Operation;
import repository.OperationRepository;
import io.quarkus.panache.common.Sort;


@Path("/fibo")
@Transactional
public class Fibonacci {
	
	@Inject
	FiboLogic fiboLogic;
	
	@Inject
    OperationRepository repo;

    @GET
    @Path("/top10")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operation> getTop10() {
    	 return repo.find("count > 0 order by count desc").range(0, 10).list();
    }
	
    @GET
    @Path("/{pos}")
    public long fibo(@PathParam("pos")int pos) {
    	return fiboLogic.resolveFibo(pos);
	}
}
