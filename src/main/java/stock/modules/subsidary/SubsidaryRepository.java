package stock.modules.subsidary;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SubsidaryRepository implements PanacheRepository<Subsidary> {

    public List<Subsidary> list() {
        return listAll();
    }

    public Subsidary getById(Long id) {
        return findById(id);
    }


    @Transactional
    public Subsidary save(Subsidary subsidary) {
        persist(subsidary);
        return subsidary;
    }

    @Transactional
    public Subsidary update(Long id, Subsidary subsidary) {
        Subsidary subsidaryEntity = findById(id);

        subsidaryEntity.setName(subsidary.getName());
        persist(subsidaryEntity);
        return subsidaryEntity;
    }

    @Transactional
    public void remove(Long id) {
        Subsidary subsidaryEntity = findById(id);

        delete(subsidaryEntity);
    }

}