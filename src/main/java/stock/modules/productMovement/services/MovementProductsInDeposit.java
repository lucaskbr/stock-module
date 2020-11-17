package stock.modules.productMovement.services;



import stock.exceptions.RequiredField;
import stock.modules.productDepositMovement.dtos.ProductDepositMovementDto;
import stock.modules.productMovement.ProductMovement;
import stock.modules.productMovement.dtos.ProductMovementDto;
import stock.modules.productMovement.factories.TypesFactory;
import stock.modules.productMovement.services.movementInDeposit.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class MovementProductsInDeposit {

    @Inject
    PickupProductReservation pickupProductReservation;

    @Inject
    BuyProducts buyProducts;

    @Inject
    AdjustProducts adjustProducts;

    @Inject
    GiveBackProducts giveBackProducts;

    @Inject
    ProductManufacturing productManufacturing;

    @Inject
    ConsumeProductsInternally consumeProductsInternally;

    @Inject
    LossOfProducts lossOfProducts;

    @Inject
    SellProducts sellProducts;


    public ProductMovement execute(ProductMovementDto productMovementDto) throws Exception {
        ProductMovement.Type type = TypesFactory.getType(productMovementDto.getType());

        switch (type) {
            case PICKUP_RESERVATION:
                return pickupProductReservation.execute(productMovementDto);
            case BUY:
                return buyProducts.execute(productMovementDto);
            case ADJUSTMENT:
                this.validateFieldsInDtoForAdjustment(productMovementDto);
                return adjustProducts.execute(productMovementDto);
            case DEVOLUTION:
                return giveBackProducts.execute(productMovementDto);
            case MANUFACTURE:
                return productManufacturing.execute(productMovementDto);
            case INTERN_CONSUMPTION:
                return consumeProductsInternally.execute(productMovementDto);
            case LOSS:
                return lossOfProducts.execute(productMovementDto);
            case SELL:
                return sellProducts.execute(productMovementDto);
            default:
                throw new Exception("Movement Type doesnt exists");
        }
    }

    private void validateFieldsInDtoForAdjustment(ProductMovementDto productMovementDto ) throws Exception {

        if (Objects.isNull(productMovementDto.getAdjustmentOperation())) {
            throw new RequiredField("adjustmentOperation");
        }

    }

//    private void genericValidation(ProductMovementDto productMovementDto) throws RequiredField {
//        if (Objects.isNull(productMovementDto.getDocumentId())) {
//            throw new RequiredField("documentId");
//        }
//
//        for (ProductDepositMovementDto item : productMovementDto.getProductDepositMovementList()) {
//            if (Objects.isNull(item.getQuantity())) {
//                throw new RequiredField("quantity");
//            }
//            if (Objects.isNull(item.getDepositId())) {
//                throw new RequiredField("depositId");
//            }
//            if (Objects.isNull(item.getProductProviderId())) {
//                throw new RequiredField("productProviderId");
//            }
//        }
//    }

}