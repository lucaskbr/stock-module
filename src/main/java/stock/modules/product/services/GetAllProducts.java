package stock.modules.product.services;

import stock.modules.product.Product;
import stock.modules.product.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetAllProducts {

    @Inject
    ProductRepository productRepository;

    public List<Product> execute() {
        return productRepository.list();
    }

}