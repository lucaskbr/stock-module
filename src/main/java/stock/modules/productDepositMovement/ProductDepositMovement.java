package stock.modules.productDepositMovement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import stock.modules.productDeposit.ProductDeposit;
import stock.modules.productMovement.ProductMovement;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "product_deposit_movement")
@Table(name = "product_deposit_movement")
public class ProductDepositMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementProductDepositMovement")
    @GenericGenerator(name = "incrementProductDepositMovement", strategy = "increment")
    private Long id;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer quantity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_deposit_id")
    private ProductDeposit productDeposit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_movement_id")
    private ProductMovement productMovement;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDeposit getProductDeposit() {
        return productDeposit;
    }

    public void setProductDeposit(ProductDeposit productDeposit) {
        this.productDeposit = productDeposit;
    }

    public ProductMovement getProductMovement() {
        return productMovement;
    }

    public void setProductMovement(ProductMovement productMovement) {
        this.productMovement = productMovement;
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

    @Override
    public String toString() {
        return "ProductDepositMovementEntity{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productDeposit=" + productDeposit +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}