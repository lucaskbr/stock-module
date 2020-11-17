package stock.modules.product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public List<Product> list() {
        return listAll();
    }

    public Product getById(Long id) {
        return findById(id);
    }

    @Transactional
    public Product save(Product product) {
        persist(product);
        return product;
    }

    @Transactional
    public Product update(Long id, Product product) throws Exception {
        Product productEntity = findById(id);

        productEntity.setName(product.getName());
        productEntity.setUnitMeasure(product.getUnitMeasure().toString());
        persist(productEntity);
        return productEntity;
    }

    @Transactional
    public void remove(Long id) {
        Product productEntity = findById(id);

        delete(productEntity);
    }

}