package stock.modules.deposit;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DepositRepository implements PanacheRepository<Deposit> {

    public List<Deposit> list() {
        return listAll();
    }

    public Deposit getById(Long id) {
        return findById(id);
    }


    @Transactional
    public Deposit save(Deposit deposit) {
        persist(deposit);
        return deposit;
    }

    @Transactional
    public Deposit update(Long id, Deposit deposit) {
        Deposit depositEntity = findById(id);

        depositEntity.setName(deposit.getName());
        persist(depositEntity);
        return depositEntity;
    }

    @Transactional
    public void remove(Long id) {
        Deposit depositEntity = findById(id);

        delete(depositEntity);
    }

}