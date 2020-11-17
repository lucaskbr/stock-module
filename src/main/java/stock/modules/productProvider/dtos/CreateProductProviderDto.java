package stock.modules.productProvider.dtos;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateProductProviderDto {

    Long id;

    @NotNull()
    BigDecimal price;

    @NotNull()
    Long productId;

    @NotNull()
    Long providerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }
}