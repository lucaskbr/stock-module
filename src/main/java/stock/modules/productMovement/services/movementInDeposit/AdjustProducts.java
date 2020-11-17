package stock.modules.productMovement.services.movementInDeposit;

import stock.modules.document.Document;
import stock.modules.document.DocumentRepository;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;
import stock.modules.productDepositMovement.ProductDepositMovement;
import stock.modules.productDepositMovement.dtos.ProductDepositMovementDto;
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

@ApplicationScoped
public class AdjustProducts {

    @Inject
    ProductDepositRepository productDepositRepository;

    @Inject
    DocumentRepository documentRepository;

    @Inject
    EntityManager em;

    @Transactional
    public ProductMovement execute(ProductMovementDto productMovementDto) throws Exception {
        try {

            Document document = documentRepository.getById(productMovementDto.getDocumentId());

            if (Objects.isNull(document)) {
                throw new Exception("Every product movement must have an documentId valid attached");
            }

            String operation = productMovementDto.getAdjustmentOperation();

            List<ProductDepositMovement> productDepositMovementList = new ArrayList<>();

            for (ProductDepositMovementDto productDepositMovementDto : productMovementDto.getProductDepositMovementList()) {

                Long productDepositId = productDepositMovementDto.getProductDepositId();

                ProductDeposit productDeposit = productDepositRepository.getById(productDepositId);

                if (Objects.isNull(productDeposit)) {
                    throw new Exception("The product in this deposit doesnt exists");
                }

                Integer currentQuantity = productDeposit.getQuantity() - productDepositMovementDto.getQuantity();

                Integer quantityAdjusted = operation.equals(ProductMovement.Type.ADJUSTMENT_ADD.toString()) ?
                        currentQuantity + productDepositMovementDto.getQuantity()
                        :
                        currentQuantity - productDepositMovementDto.getQuantity();

                productDeposit.setQuantity(quantityAdjusted);

                ProductDepositMovement productDepositMovement = new ProductDepositMovement();
                productDepositMovement.setPrice(productDeposit.getPrice());
                productDepositMovement.setProductDeposit(productDeposit);
                productDepositMovement.setQuantity(productDepositMovementDto.getQuantity());

                em.persist(productDeposit);
                em.persist(productDepositMovement);

                productDepositMovementList.add(productDepositMovement);

            }

            ProductMovement productMovement = ProductMovementMapper.INSTANCE.dtoToEntity(productMovementDto);

            if (ProductMovement.Type.ADJUSTMENT_ADD.toString().equals(operation)) {
                productMovement.setType(ProductMovement.Type.ADJUSTMENT_ADD);
            } else {
                productMovement.setType(ProductMovement.Type.ADJUSTMENT_REMOVE);
            }

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