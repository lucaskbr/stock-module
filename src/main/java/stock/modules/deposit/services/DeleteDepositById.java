package stock.modules.deposit.services;


import stock.modules.deposit.DepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteDepositById {

    @Inject
    DepositRepository depositRepository;

    public void execute(Long id) {
        depositRepository.remove(id);
    }

}