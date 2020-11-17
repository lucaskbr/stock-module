package stock.modules.productDeposit.dto;


import javax.validation.constraints.NotNull;

public class CreateProductDepositDto {

    @NotNull
    Integer quantity;

    @NotNull
    Long productProviderId;

    @NotNull
    Long depositId;


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
}