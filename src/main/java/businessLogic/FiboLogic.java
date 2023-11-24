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
		  // Verificar si ya existe una entrada para la posición en la base de datos
	    Operation existingOp = repo.findByPos(pos);
	    if (existingOp != null) {
	        // Si ya existe, retornar el resultado almacenado
	        existingOp.setCount(existingOp.getCount() + 1);
	        repo.persist(existingOp);
	        return existingOp.getResult();
	    }

	  /*
	    if (pos <= 1) {
	    	existingOp = repo.findByPos(pos);
	    	 if (existingOp == null) {
		            
		            Operation op = new Operation(pos, pos, 1);
		            repo.persist(op);
		            return op.getResult();
		        } else {  
		            existingOp.setCount(existingOp.getCount() + 1);
		            repo.persist(existingOp);
		            return existingOp.getResult();
		        }
	    }
	    */

	    long prev = 0;
	    long current = 1;

	    for (int i = 0; i <= pos; i++) {
	        long next = prev + current;
	        prev = current;
	        current = next;
	        if(i==0) {
	        	prev=0;
	        	next= 0;
	        }
	        if(i==1) {
	        	prev=0;
	        	next= 1;
	        }
	        // Verificar si ya existe una entrada para la posición
	        existingOp = repo.findByPos(i);
	        if (existingOp == null) {
	            // Guardar resultado intermedio solo si no existe
	        	
	        		Operation op = new Operation(i, next, 0);
	        		if(i==pos) {
	        			op.setCount(1);
	        		}
	            
	            repo.persist(op);
	        }
	    }


		    return current;
	}
}
