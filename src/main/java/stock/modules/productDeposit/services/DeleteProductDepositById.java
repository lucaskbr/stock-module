package stock.modules.productDeposit.services;


import stock.modules.productDeposit.ProductDepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteProductDepositById {

    @Inject
    ProductDepositRepository productDepositRepository;

    public void execute(Long id) {
        productDepositRepository.remove(id);
    }

}