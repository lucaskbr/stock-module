package stock.modules.productProvider.services;


import stock.modules.product.ProductRepository;
import stock.modules.productProvider.ProductProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteProductProviderById {

    @Inject
    ProductProviderRepository productProviderRepository;

    public void execute(Long id) {
        productProviderRepository.remove(id);
    }

}