package stock.modules.productProvider;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductProviderRepository implements PanacheRepository<ProductProvider> {

    @Inject
    EntityManager em;

    public List<ProductProvider> list() {
        return listAll();
    }

    public ProductProvider getById(Long id) {
        return findById(id);
    }

    @Transactional
    public ProductProvider save(ProductProvider productProvider) {
        persist(productProvider);
        return productProvider;
    }

    @Transactional
    public ProductProvider update(Long id, ProductProvider productProvider) throws Exception {
        ProductProvider productProviderEntity = findById(id);

        productProviderEntity.setPrice(productProvider.getPrice());
        persist(productProviderEntity);
        return productProviderEntity;
    }

    public ProductProvider getProductProviderByProductIdAndDepositId(Long productId, Long providerId) {
        try {
            String hql = "SELECT pp FROM product_provider pp WHERE product_id = :productId AND provider_id = :providerId";

            return (ProductProvider) em.createQuery(hql)
                    .setParameter("productId", productId)
                    .setParameter("providerId", providerId)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public void remove(Long id) {
        ProductProvider productProviderEntity = findById(id);

        delete(productProviderEntity);
    }

}