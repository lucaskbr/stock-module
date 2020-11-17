package stock.modules.productProvider.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import stock.modules.productProvider.ProductProvider;
import stock.modules.productProvider.dtos.CreateProductProviderDto;

@Mapper
public interface ProductProviderMapper {

    ProductProviderMapper INSTANCE = Mappers.getMapper(ProductProviderMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "productId ", source = "product.id")
    @Mapping(target = "providerId", source = "provider.id")
    CreateProductProviderDto entityToCreateProductProviderDto(ProductProvider source) throws Exception;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "provider.id", source = "providerId")
    ProductProvider createProductProviderDtoToEntity(CreateProductProviderDto source) throws Exception;

}