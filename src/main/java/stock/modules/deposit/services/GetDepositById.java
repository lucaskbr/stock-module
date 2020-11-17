package stock.modules.deposit.services;

import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetDepositById {

    @Inject
    DepositRepository depositRepository;

    public Deposit execute(Long id) {
       return depositRepository.getById(id);
    }

}