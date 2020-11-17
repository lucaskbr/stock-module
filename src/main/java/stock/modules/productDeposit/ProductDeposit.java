package stock.modules.productDeposit;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import stock.modules.deposit.Deposit;
import stock.modules.productProvider.ProductProvider;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "product_deposit")
@Table(name = "product_deposit")
public class ProductDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementProductDeposit")
    @GenericGenerator(name = "incrementProductDeposit", strategy = "increment")
    private Long id;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Column(name="average_price")
    private BigDecimal averagePrice;

    @NotNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_provider_id")
    private ProductProvider productProvider;

    @ManyToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    @CreationTimestamp
    @Column(name="created_at", updatable = false, insertable = true)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

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

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductProvider getProductProvider() {
        return productProvider;
    }

    public void setProductProvider(ProductProvider productProvider) {
        this.productProvider = productProvider;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
