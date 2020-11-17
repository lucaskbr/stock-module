package stock.modules.productMovement;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import stock.modules.productDepositMovement.ProductDepositMovement;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductMovementRepository implements PanacheRepository<ProductMovement> {

    public List<ProductMovement> list() {
        return listAll();
    }

    public ProductMovement getById(Long id) {
        return findById(id);
    }

    @Transactional
    public ProductMovement save(ProductMovement productMovement) {
        persist(productMovement);
        return productMovement;
    }

    @Transactional
    public void remove(Long id) {
        ProductMovement productMovementEntity = findById(id);
        delete(productMovementEntity);
    }

}