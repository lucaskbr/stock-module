package stock.modules.productMovement.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import stock.modules.productMovement.ProductMovement;
import stock.modules.productMovement.dtos.ProductMovementDto;

@Mapper
public interface ProductMovementMapper {

    ProductMovementMapper INSTANCE = Mappers.getMapper(ProductMovementMapper.class);

    @Mapping(target = "type", source = "type")
    ProductMovement dtoToEntity(ProductMovementDto productMovementDto);

}