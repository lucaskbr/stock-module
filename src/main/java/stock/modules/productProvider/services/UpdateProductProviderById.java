package stock.modules.productProvider.services;

import stock.modules.productProvider.ProductProvider;
import stock.modules.productProvider.ProductProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateProductProviderById {

    @Inject
    ProductProviderRepository productProviderRepository;

    public ProductProvider execute(Long id, ProductProvider productProvider) throws Exception {
        return productProviderRepository.update(id, productProvider);
    }

}