package stock.modules.productMovement.dtos;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BuyProductDto {

    @NotNull
    Long productDepositId;

    @NotNull
    Long productId;

    BigDecimal price;

    Integer quantity;

    public Long getProductDepositId() {
        return productDepositId;
    }

    public void setProductDepositId(Long productDepositId) {
        this.productDepositId = productDepositId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
}