package stock.modules.productMovement.services.movementInDeposit;

import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;
import stock.modules.productDepositMovement.ProductDepositMovement;
import stock.modules.productDepositMovement.dtos.ProductDepositMovementDto;
import stock.modules.productDepositMovement.mappers.ProductDepositMovementMapper;
import stock.modules.productMovement.ProductMovement;
import stock.modules.productMovement.dtos.ProductMovementDto;
import stock.modules.productMovement.mappers.ProductMovementMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class SellProducts {

    @Inject
    ProductDepositRepository productDepositRepository;

    @Inject
    EntityManager em;

    @Transactional
    public ProductMovement execute(ProductMovementDto productMovementDto) throws Exception {
        try {

            List<ProductDepositMovement> productDepositMovementList = new ArrayList<>();

            for (ProductDepositMovementDto productDepositMovementDto : productMovementDto.getProductDepositMovementList()) {

                Long productDepositId = productDepositMovementDto.getProductDepositId();
                ProductDeposit productDeposit = productDepositRepository.getById(productDepositId);

                if (Objects.isNull(productDeposit)) {
                    throw new Exception("The product in this deposit doesnt exists");
                }

                Integer currentQuantity = productDeposit.getQuantity() - productDepositMovementDto.getQuantity();

                if (currentQuantity <= 0) {
                    throw new Exception("The quantity exceeds the current stock");
                }

                productDeposit.setQuantity(currentQuantity);

                ProductDepositMovement productDepositMovement = new ProductDepositMovement();
                productDepositMovement.setPrice(productDeposit.getPrice());
                productDepositMovement.setProductDeposit(productDeposit);
                productDepositMovement.setQuantity(productDepositMovementDto.getQuantity());

                em.persist(productDeposit);
                em.persist(productDepositMovement);
                productDepositMovementList.add(productDepositMovement);

            }

            ProductMovement productMovement = ProductMovementMapper.INSTANCE.dtoToEntity(productMovementDto);
            productMovement.setType(ProductMovement.Type.SELL);

            em.persist(productMovement);

            productDepositMovementList.forEach(item -> {
                item.setProductMovement(productMovement);
                em.persist(item);
            });

            return productMovement;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

