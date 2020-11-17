package stock.modules.deposit.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import stock.modules.deposit.Deposit;
import stock.modules.deposit.dtos.CreateDepositDto;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.dto.ProductDepositDto;

@Mapper
public interface DepositMapper {

    DepositMapper INSTANCE = Mappers.getMapper(DepositMapper.class);


    @Mapping(target = "subsidaryId", source = "subsidary.id")
    @Mapping(target = "localId", source = "local.id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "thirdParty", source = "thirdParty")
    CreateDepositDto entityToCreateDepositDto(Deposit source);

    @Mapping(target = "subsidary.id", source = "subsidaryId")
    @Mapping(target = "local.id", source = "localId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "thirdParty", source = "thirdParty")
    Deposit  createDepositDtoToEntity(CreateDepositDto source);

}