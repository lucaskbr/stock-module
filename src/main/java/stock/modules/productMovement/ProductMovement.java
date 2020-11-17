package stock.modules.productMovement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import stock.modules.document.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "product_movement")
@Table(name = "product_movement")
public class ProductMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementProductMovement")
    @GenericGenerator(name = "incrementProductMovement", strategy = "increment")
    private Long id;

    public enum Type {
        PICKUP_RESERVATION,
        SELL,
        BUY,
        INTERN_CONSUMPTION,
        MANUFACTURE,
        DEVOLUTION,
        LOSS,
        ADJUSTMENT,
        ADJUSTMENT_ADD,
        ADJUSTMENT_REMOVE;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne
    @JoinColumn(name = "document_id")
    private Document document;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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
