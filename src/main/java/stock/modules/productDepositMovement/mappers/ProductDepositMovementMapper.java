package stock.modules.productDepositMovement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import stock.modules.productDepositMovement.ProductDepositMovement;
import stock.modules.productDepositMovement.dtos.ProductDepositMovementDto;
import stock.modules.productMovement.ProductMovement;
import stock.modules.productMovement.dtos.BuyProductDto;

@Mapper
public interface ProductDepositMovementMapper {

    ProductDepositMovementMapper INSTANCE = Mappers.getMapper(ProductDepositMovementMapper.class);

    @Mapping(target = "productDeposit.id", source = "productDepositId")
    @Mapping(target = "productDeposit.productProvider.id", source = "productProviderId")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    ProductDepositMovement dtoToEntity(ProductDepositMovementDto source);

    @Mapping(target = "productDepositId", source = "productDeposit.id")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "price")
    ProductDepositMovementDto entityToDto(ProductDepositMovement source);


}