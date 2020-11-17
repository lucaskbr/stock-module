package stock.modules.productDeposit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.dto.CreateProductDepositDto;
import stock.modules.productDeposit.dto.ProductDepositDto;

@Mapper
public interface ProductDepositMapper {

    ProductDepositMapper INSTANCE = Mappers.getMapper(ProductDepositMapper.class);

    @Mapping(target = "deposit.id", source = "depositId")
    @Mapping(target = "productProvider.id", source = "productProviderId")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "averagePrice", source = "averagePrice")
    ProductDeposit dtoToEntity(ProductDepositDto source);

    @Mapping(target = "depositId", source = "deposit.id")
    @Mapping(target = "productProviderId", source = "productProvider.id")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "averagePrice", source = "averagePrice")
    ProductDepositDto entityToDto(ProductDeposit source);

    @Mapping(target = "depositId", source = "deposit.id")
    @Mapping(target = "productProviderId", source = "productProvider.id")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price", ignore = true)
    @Mapping(target = "averagePrice", source = "averagePrice", ignore = true)
    ProductDepositDto entityToThirdDto(ProductDeposit source);


    @Mapping(target = "depositId", source = "deposit.id")
    @Mapping(target = "productProviderId", source = "productProvider.id")
    @Mapping(target = "quantity", source = "quantity")
    CreateProductDepositDto entityToCreateProductDepositThirdDto(ProductDeposit source);

    @Mapping(target = "deposit.id", source = "depositId")
    @Mapping(target = "productProvider.id", source = "productProviderId")
    @Mapping(target = "quantity", source = "quantity")
    ProductDeposit  createProductDepositDtoToEntity(CreateProductDepositDto source);


}