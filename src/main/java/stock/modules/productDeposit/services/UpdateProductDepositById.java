package stock.modules.productDeposit.services;

import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateProductDepositById {

    @Inject
    ProductDepositRepository productDepositRepository;

    public ProductDeposit execute(Long id, ProductDeposit productDeposit) {
        return productDepositRepository.update(id, productDeposit);
    }

}