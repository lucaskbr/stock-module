package stock.modules.productMovement.dtos;

import stock.modules.productDepositMovement.dtos.ProductDepositMovementDto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ProductMovementDto {

    @NotNull
    String type;

    @NotNull
    Long documentId;

    String adjustmentOperation;

    @NotNull
    List<ProductDepositMovementDto> productDepositMovementList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getAdjustmentOperation() {
        return adjustmentOperation;
    }

    public void setAdjustmentOperation(String adjustmentOperation) {
        this.adjustmentOperation = adjustmentOperation;
    }

    public List<ProductDepositMovementDto> getProductDepositMovementList() {
        return productDepositMovementList;
    }

    public void setProductDepositMovementList(List<ProductDepositMovementDto> productDepositMovementList) {
        this.productDepositMovementList = productDepositMovementList;
    }

    @Override
    public String toString() {
        return "ProductMovementDto{" +
                "type='" + type + '\'' +
                ", productDepositMovementList=" + productDepositMovementList +
                '}';
    }
}