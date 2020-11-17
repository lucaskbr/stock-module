package stock.modules.productDepositMovement.dtos;

import java.math.BigDecimal;

public class ProductDepositMovementDto {

    Long depositId;

    Long productDepositId;

    Long productProviderId;

    BigDecimal price;

    Integer quantity;

    String operation;

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    public Long getProductDepositId() {
        return productDepositId;
    }

    public void setProductDepositId(Long productDepositId) {
        this.productDepositId = productDepositId;
    }

    public Long getProductProviderId() {
        return productProviderId;
    }

    public void setProductProviderId(Long productProviderId) {
        this.productProviderId = productProviderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}