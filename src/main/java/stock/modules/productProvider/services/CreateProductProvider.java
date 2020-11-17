package stock.modules.productProvider.services;


import stock.modules.product.Product;
import stock.modules.product.ProductRepository;
import stock.modules.productProvider.ProductProvider;
import stock.modules.productProvider.ProductProviderRepository;
import stock.modules.productProvider.dtos.CreateProductProviderDto;
import stock.modules.productProvider.mappers.ProductProviderMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class CreateProductProvider {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductProviderRepository productProviderRepository;


    public CreateProductProviderDto execute(CreateProductProviderDto createProductProviderDto) throws Exception {
        Long productId = createProductProviderDto.getProductId();
        Long providerId = createProductProviderDto.getProviderId();

        ProductProvider productProviderExists = productProviderRepository.getProductProviderByProductIdAndDepositId(productId, providerId);

        if (!Objects.isNull(productProviderExists)) {
            throw new Exception("Product provider already exists");
        }

        ProductProvider productProvider = ProductProviderMapper.INSTANCE.createProductProviderDtoToEntity(createProductProviderDto);
        return ProductProviderMapper.INSTANCE.entityToCreateProductProviderDto(productProviderRepository.save(productProvider));
    }

}