package stock.modules.local;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LocalRepository implements PanacheRepository<Local> {

    public List<Local> list() {
        return listAll();
    }

    public Local getById(Long id) {
        return findById(id);
    }


    @Transactional
    public Local save(Local local) {
        persist(local);
        return local;
    }

    @Transactional
    public Local update(Long id, Local local) {
        Local localEntity = findById(id);

        localEntity.setName(local.getName());
        persist(localEntity);
        return localEntity;
    }

    @Transactional
    public void remove(Long id) {
        Local localEntity = findById(id);

        delete(localEntity);
    }

}