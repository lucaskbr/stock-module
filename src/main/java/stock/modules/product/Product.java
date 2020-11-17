package stock.modules.product;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementProduct")
    @GenericGenerator(name = "incrementProduct", strategy = "increment")
    private Long id;

    @NotBlank(message="Name may not be blank")
    @Column(unique=true)
    private String name;

    public enum UnitMeasure {
        OZ, KG, MG, G, L, ML, M, CM, MM ;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="unit_measure")
    private UnitMeasure unitMeasure;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitMeasure getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) throws Exception {
        switch (unitMeasure) {
            case "OZ":
                this.unitMeasure = UnitMeasure.OZ;
                break;
            case "KG":
                this.unitMeasure = UnitMeasure.KG;
                break;
            case "MG":
                this.unitMeasure = UnitMeasure.MG;
                break;
            case "G":
                this.unitMeasure = UnitMeasure.G;
                break;
            case "L":
                this.unitMeasure = UnitMeasure.L;
                break;
            case "ML":
                this.unitMeasure = UnitMeasure.ML;
                break;
            case "M":
                this.unitMeasure = UnitMeasure.M;
                break;
            case "CM":
                this.unitMeasure = UnitMeasure.CM;
                break;
            case "MM":
                this.unitMeasure = UnitMeasure.MM;
                break;
            default:
                throw new Exception("Unit measure not defined");
        }
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