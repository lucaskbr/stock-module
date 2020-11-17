package stock.modules.deposit.services;

import stock.exceptions.EntityNotFound;
import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;
import stock.modules.deposit.dtos.CreateDepositDto;
import stock.modules.deposit.mappers.DepositMapper;
import stock.modules.local.Local;
import stock.modules.local.LocalRepository;
import stock.modules.subsidary.Subsidary;
import stock.modules.subsidary.SubsidaryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class CreateDeposit {

    @Inject
    DepositRepository depositRepository;

    @Inject
    LocalRepository localRepository;

    @Inject
    SubsidaryRepository subsidaryRepository;


    public CreateDepositDto execute(CreateDepositDto createDepositDto) throws EntityNotFound {

        Local local = localRepository.getById(createDepositDto.getLocalId());

        if (Objects.isNull(local)) {
            throw new EntityNotFound("The local entity doesnt exists");
        }

        Subsidary subsidary = subsidaryRepository.getById(createDepositDto.getSubsidaryId());

        if (Objects.isNull(subsidary)) {
            throw new EntityNotFound("The subsidary entity doesnt exists");
        }

        Deposit deposit = DepositMapper.INSTANCE.createDepositDtoToEntity(createDepositDto);

        return DepositMapper.INSTANCE.entityToCreateDepositDto(depositRepository.save(deposit));

    }

}