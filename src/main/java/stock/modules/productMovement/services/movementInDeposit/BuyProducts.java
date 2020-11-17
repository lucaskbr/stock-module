package stock.modules.productMovement.services.movementInDeposit;

import stock.modules.deposit.Deposit;
import stock.modules.deposit.DepositRepository;
import stock.modules.document.Document;
import stock.modules.document.DocumentRepository;
import stock.modules.product.Product;
import stock.modules.product.ProductRepository;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productDeposit.ProductDepositRepository;
import stock.modules.productDepositMovement.ProductDepositMovement;
import stock.modules.productDepositMovement.dtos.ProductDepositMovementDto;
import stock.modules.productDepositMovement.mappers.ProductDepositMovementMapper;
import stock.modules.productMovement.ProductMovement;
import stock.modules.productMovement.ProductMovementRepository;
import stock.modules.productMovement.dtos.ProductMovementDto;
import stock.modules.productMovement.mappers.ProductMovementMapper;
import stock.modules.productProvider.ProductProvider;
import stock.modules.productProvider.ProductProviderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class BuyProducts {

    @Inject
    DocumentRepository documentRepository;

    @Inject
    ProductDepositRepository productDepositRepository;

    @Inject
    DepositRepository depositRepository;

    @Inject
    ProductProviderRepository productProviderRepository;

    @Inject
    EntityManager em;

    @Transactional
    public ProductMovement execute(ProductMovementDto productMovementDto) throws Exception {
        try {

            Document document = documentRepository.getById(productMovementDto.getDocumentId());

            if (Objects.isNull(document)) {
                throw new Exception("Every product movement must have an documentId valid attached");
            }

            List<ProductDepositMovement> productDepositMovementList = new ArrayList<>();

            for (ProductDepositMovementDto productDepositMovementDto : productMovementDto.getProductDepositMovementList()) {

                Long depositId = productDepositMovementDto.getDepositId();
                Long productProviderId = productDepositMovementDto.getProductProviderId();


                ProductDeposit productDeposit = productDepositRepository.getByDepositIdAndProductProviderId(depositId, productProviderId);

                if (Objects.isNull(productDeposit)) {
                    ProductProvider productProvider = productProviderRepository.getById(productProviderId);

                    if (Objects.isNull(productProvider)) {
                        throw new Exception("The productProvider doesnt exists");
                    }

                    Deposit deposit = depositRepository.getById(depositId);

                    if (Objects.isNull(deposit)) {
                        throw new Exception("The deposit doesnt exists");
                    }

                    ProductDeposit newProductDeposit = new ProductDeposit();
                    newProductDeposit.setProductProvider(productProvider);
                    newProductDeposit.setPrice(BigDecimal.valueOf(0));
                    newProductDeposit.setAveragePrice(BigDecimal.valueOf(0));
                    newProductDeposit.setQuantity(0);
                    newProductDeposit.setDeposit(deposit);

                    productDeposit = newProductDeposit;

                }

                Integer totalQuantity = productDeposit.getQuantity() + productDepositMovementDto.getQuantity();
                Double oldTotalPrice = productDeposit.getPrice().doubleValue() * productDeposit.getQuantity();
                Double currentTotalPrice = productDepositMovementDto.getPrice().doubleValue() * productDepositMovementDto.getQuantity();
                BigDecimal averagePrice = BigDecimal.valueOf((oldTotalPrice + currentTotalPrice) / totalQuantity);
                Integer currentQuantity = productDeposit.getQuantity() + productDepositMovementDto.getQuantity();

                BigDecimal price = productDepositMovementDto.getPrice();

                productDeposit.setPrice(price);
                productDeposit.setAveragePrice(averagePrice);
                productDeposit.setQuantity(currentQuantity);
                em.persist(productDeposit);

                ProductDepositMovement productDepositMovement = new ProductDepositMovement();

                productDepositMovement.setPrice(price);
                productDepositMovement.setProductDeposit(productDeposit);
                productDepositMovement.setQuantity(productDeposit.getQuantity());
                em.persist(productDepositMovement);

                productDepositMovementList.add(productDepositMovement);

            }

            ProductMovement productMovement = ProductMovementMapper.INSTANCE.dtoToEntity(productMovementDto);
            productMovement.setType(ProductMovement.Type.BUY);
            productMovement.setDocument(document);
           // productMovement.setCreatedAt(LocalDateTime.now());

            em.persist(productMovement);


            productDepositMovementList.forEach(item -> {
                item.setProductMovement(productMovement);
                // item.setCreatedAt(LocalDateTime.now());
                em.persist(item);
            });

            return productMovement;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}