package stock.modules.product.services;


import stock.modules.product.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteProductById {

    @Inject
    ProductRepository productRepository;

    public void execute(Long id) {
        productRepository.remove(id);
    }

}