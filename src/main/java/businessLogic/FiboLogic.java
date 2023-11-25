package businessLogic;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import models.Operation;
import repository.OperationRepository;

import java.util.List;

@ApplicationScoped
@Transactional
public class FiboLogic {
	
	@Inject
	OperationRepository repo;


	// resolves the Fibbonacci, saves in the database the consulted entry (pos)
	// and saves in the database the intermediate values
	public long resolveFibo(int pos) {
		// particular case
		if(pos==0){
			Operation existingOp = verifyAndPersistOP(pos);
			if (existingOp != null) {
				return existingOp.getResult();
			}
			return pos;
		}
		// verify if the operation exist in the database
		Operation existingOp = verifyAndPersistOP(pos);
	    if (existingOp != null) {
	        return existingOp.getResult();
	    }

	    long prev = 0;
	    long current = 1;

	    for (int i = 0; i <= pos; i++) {
	        long next = prev + current;
	        prev = current;
	        current = next;
			//fixing particular cases f(0) and f(1)
	        if(i==0) {
	        	prev=0;
	        	next= 0;
	        }
	        if(i==1) {
	        	prev=0;
	        	next= 1;
	        }

	        existingOp = repo.findByPos(i);
	        if (existingOp == null) {
				Operation op = new Operation(i, next, 0);
				if(i==pos) {
					op.setCount(1);
				}
	            repo.persist(op);
	        }
	    }

		return current;
	}

	//returns a list of results ordered by count
	//to get the top 10 of the most consulted entries
	public List<Operation> getTop10(){
		List<Operation> top10List = repo.find("count > 0 order by count desc")
				.page(0, 10)
				.list();
		return top10List;
	}

	// verify if the operation exist in the database
	// in case it exists: count +1
	public Operation verifyAndPersistOP(int pos){
		Operation existingOp = repo.findByPos(pos);
		if (existingOp != null) {
			existingOp.setCount(existingOp.getCount() + 1);
			repo.persist(existingOp);
			return existingOp;
		}
		return existingOp;
	}
}
