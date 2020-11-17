package stock.modules.productDeposit.services;

import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetProductDepositById {

    @Inject
    ProductDepositRepository productDepositRepository;

    public ProductDeposit execute(Long id) {
       return productDepositRepository.getById(id);
    }

}