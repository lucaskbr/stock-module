package stock.modules.deposit.services;

import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateDepositById {

    @Inject
    DepositRepository depositRepository;

    public Deposit execute(Long id, Deposit deposit) {
        return depositRepository.update(id, deposit);
    }

}