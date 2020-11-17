package stock.modules.provider;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProviderRepository implements PanacheRepository<Provider> {

    public List<Provider> list() {
        return listAll();
    }

    public Provider getById(Long id) {
        return findById(id);
    }

    @Transactional
    public Provider save(Provider provider) {
        persist(provider);
        return provider;
    }

    @Transactional
    public Provider update(Long id, Provider provider) {
        Provider providerEntity = findById(id);

        providerEntity.setName(provider.getName());
        persist(providerEntity);
        return providerEntity;
    }

    @Transactional
    public void remove(Long id) {
        Provider providerEntity = findById(id);

        delete(providerEntity);
    }

}