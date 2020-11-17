package stock.modules.deposit.services;

import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetAllDeposits {

    @Inject
    DepositRepository depositRepository;

    public List<Deposit> execute() {
        return depositRepository.list();
    }

}