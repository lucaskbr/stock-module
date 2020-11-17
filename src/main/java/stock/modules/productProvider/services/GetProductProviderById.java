package stock.modules.productProvider.services;

import stock.modules.productProvider.ProductProvider;
import stock.modules.productProvider.ProductProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetProductProviderById {

    @Inject
    ProductProviderRepository productProviderRepository;

    public ProductProvider execute(Long id) {
       return productProviderRepository.getById(id);
    }

}