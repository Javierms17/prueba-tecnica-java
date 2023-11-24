package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import models.Operation;

@ApplicationScoped
public class OperationRepository implements PanacheRepository<Operation> {
    public Operation findByPos(int pos) {
        return find("pos", pos).firstResult();
    }
}
