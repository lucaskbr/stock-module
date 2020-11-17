package stock.modules.productDeposit.services;

import stock.exceptions.EntityNotFound;
import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;
import stock.modules.product.Product;
import stock.modules.product.ProductRepository;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;
import stock.modules.productDeposit.dto.CreateProductDepositDto;
import stock.modules.productDeposit.mappers.ProductDepositMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class CreateProductDeposit {

    @Inject
    ProductDepositRepository productDepositRepository;

    @Inject
    ProductRepository productRepository;

    @Inject
    DepositRepository depositRepository;


    public CreateProductDepositDto execute(CreateProductDepositDto createProductDepositDto) throws Exception {

//        Long productId = createProductDepositDto.getProductId();
//        Long depositId = createProductDepositDto.getDepositId();
//
//        Optional<ProductDeposit> productDepositExists = productDepositRepository.getByDepositIdAndProductId(depositId, productId);
//
//        if (productDepositExists.isPresent()) {
//            throw new Exception("The product already exists in the deposit");
//        }
//
//        Product product = productRepository.getById(productId);
//
//        if (Objects.isNull(product)) {
//            throw new EntityNotFound("Product doesnt exists");
//        }
//
//        Deposit deposit = depositRepository.getById(depositId);
//
//        if (Objects.isNull(deposit)) {
//            throw new EntityNotFound("Deposit doesnt exists");
//        }
//
//        BigDecimal quantity = BigDecimal.valueOf(createProductDepositDto.getQuantity());
//        BigDecimal productCurrentPrice = product.getPrice();
//        BigDecimal averagePrice = product.getPrice().multiply(quantity).divide(quantity);
//
//        ProductDeposit productDeposit = new ProductDeposit();
//        productDeposit.setProduct(product);
//        productDeposit.setDeposit(deposit);
//        productDeposit.setQuantity(quantity.intValue());
//        productDeposit.setPrice(productCurrentPrice);
//        productDeposit.setAveragePrice(averagePrice);
//
//
//        return ProductDepositMapper.INSTANCE.entityToCreateProductDepositThirdDto(productDepositRepository.save(productDeposit));

        return null;

    }

}