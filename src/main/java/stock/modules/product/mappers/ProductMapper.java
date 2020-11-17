package stock.modules.product.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import stock.modules.deposit.Deposit;
import stock.modules.product.Product;
import stock.modules.product.dtos.CreateProductDto;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "unitMeasure", source = "unitMeasure")
    CreateProductDto entityToCreateProductDto(Product source) throws Exception;

    @Mapping(target = "name", source = "name")
    @Mapping(target = "unitMeasure", source = "unitMeasure")
    Product createProductDtoToEntity(CreateProductDto source) throws Exception;

}