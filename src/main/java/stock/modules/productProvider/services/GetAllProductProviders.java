package stock.modules.productProvider.services;

import stock.modules.productProvider.ProductProvider;
import stock.modules.productProvider.ProductProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetAllProductProviders {

    @Inject
    ProductProviderRepository productProviderRepository;

    public List<ProductProvider> execute() {
        return productProviderRepository.list();
    }

}