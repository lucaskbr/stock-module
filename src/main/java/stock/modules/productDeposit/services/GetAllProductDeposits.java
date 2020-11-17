package stock.modules.productDeposit.services;

import stock.exceptions.EntityNotFound;
import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;
import stock.modules.productDeposit.dto.ProductDepositDto;
import stock.modules.productDeposit.mappers.ProductDepositMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class GetAllProductDeposits {

    @Inject
    ProductDepositRepository productDepositRepository;

    @Inject
    DepositRepository depositRepository;

    public List<ProductDepositDto> execute(Long depositId) throws EntityNotFound {

        if (!Objects.isNull(depositId)) {
            Deposit deposit = depositRepository.getById(depositId);

            if (Objects.isNull(deposit)) {
                throw new EntityNotFound("Deposit doesnt exists");
            }

            List<ProductDeposit> productDepositList = productDepositRepository.listAllByDepositId(depositId);

            return productDepositList
                    .stream()
                    .map(ProductDepositMapper.INSTANCE::entityToThirdDto)
                    .collect(Collectors.toList());

        }
        return productDepositRepository
                .list()
                .stream()
                .map(ProductDepositMapper.INSTANCE::entityToDto)
                .collect(Collectors.toList());
    }

}