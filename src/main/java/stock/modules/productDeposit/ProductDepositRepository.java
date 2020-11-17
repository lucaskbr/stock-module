package stock.modules.productDeposit;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import stock.modules.productProvider.ProductProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductDepositRepository implements PanacheRepository<ProductDeposit> {

    @Inject
    EntityManager em;


    public List<ProductDeposit> list() {
        return listAll();
    }

    public List listAllByDepositId(Long depositId) {
        String query = ("SELECT pd FROM product_deposit pd ")
                .concat("WHERE deposit_id = " + depositId);
        return list(query);
    }

    public ProductDeposit getByDepositIdAndProductProviderId(Long depositId, Long productProviderId) {
        try {
            String hql = ("SELECT pd FROM product_deposit pd WHERE deposit_id = :depositId AND product_provider_id = :productProviderId");
            return (ProductDeposit) em.createQuery(hql)
                    .setParameter("depositId", depositId)
                    .setParameter("productProviderId", productProviderId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public ProductDeposit getById(Long id) {
        return findById(id);
    }

    @Transactional
    public ProductDeposit save(ProductDeposit productDeposit) {
        persist(productDeposit);
        return productDeposit;
    }

    @Transactional
    public ProductDeposit update(Long id, ProductDeposit productDeposit) {
        ProductDeposit productDepositEntity = findById(id);

        productDepositEntity.setQuantity(productDeposit.getQuantity());
        productDepositEntity.setPrice(productDeposit.getPrice());
        productDepositEntity.setAveragePrice(productDeposit.getAveragePrice());
        persist(productDepositEntity);
        return productDepositEntity;
    }

    @Transactional
    public void remove(Long id) {
        ProductDeposit productMovementEntity = findById(id);
        delete(productMovementEntity);
    }

    public void update(ProductDeposit productDeposit) {
    }
}