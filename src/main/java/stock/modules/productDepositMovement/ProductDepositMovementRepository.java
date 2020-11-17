package stock.modules.productDepositMovement;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import stock.modules.productDepositMovement.ProductDepositMovement;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductDepositMovementRepository implements PanacheRepository<ProductDepositMovement> {

    public List<ProductDepositMovement> list() {
        return listAll();
    }

    public ProductDepositMovement getById(Long id) {
        return findById(id);
    }

    @Transactional
    public ProductDepositMovement save(ProductDepositMovement productDepositMovement) {
        persist(productDepositMovement);
        return productDepositMovement;
    }

    @Transactional
    public void remove(Long id) {
        ProductDepositMovement productMovementEntity = findById(id);
        delete(productMovementEntity);
    }

}