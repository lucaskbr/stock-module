package stock.modules.product.services;


import stock.exceptions.EntityNotFound;
import stock.modules.product.Product;
import stock.modules.product.ProductRepository;
import stock.modules.product.dtos.CreateProductDto;
import stock.modules.product.mappers.ProductMapper;
import stock.modules.provider.Provider;
import stock.modules.provider.ProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class CreateProduct {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProviderRepository providerRepository;

    public CreateProductDto execute(CreateProductDto createProductDto) throws Exception {

       Product product = ProductMapper.INSTANCE.createProductDtoToEntity(createProductDto);

        return ProductMapper.INSTANCE.entityToCreateProductDto(productRepository.save(product));
    }

}