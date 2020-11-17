package stock.modules.productDeposit.dto;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDepositDto {

    @NotNull
    Integer quantity;

    @NotNull
    Long productProviderId;

    @NotNull
    Long depositId;

    BigDecimal price;

    BigDecimal averagePrice;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductProviderId() {
        return productProviderId;
    }

    public void setProductProviderId(Long productProviderId) {
        this.productProviderId = productProviderId;
    }

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

}