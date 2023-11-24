package businessLogic;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import models.Operation;
import repository.OperationRepository;

@ApplicationScoped
public class FiboLogic {
	
	@Inject
	OperationRepository repo;
	

	public long resolveFibo(int pos) {
		if (pos <= 1) {
	       return pos;
		}
		
		long prev = 0;
		long current = 1;
		
		for (int i = 2; i <= pos; i++) {
		    long next = prev + current;
		    prev = current;
		    current = next;
		}
		
		Operation op= new Operation(pos, current, 1);
		repo.persist(op);
	
		
		return current;
	}
}
