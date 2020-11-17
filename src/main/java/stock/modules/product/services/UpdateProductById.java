package stock.modules.product.services;

import stock.modules.product.Product;
import stock.modules.product.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateProductById {

    @Inject
    ProductRepository productRepository;

    public Product execute(Long id, Product product) throws Exception {
        return productRepository.update(id, product);
    }

}