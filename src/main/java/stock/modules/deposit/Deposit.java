package stock.modules.deposit;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import stock.modules.local.Local;
import stock.modules.subsidary.Subsidary;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "deposit")
@Table(name = "deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDeposit")
    @GenericGenerator(name = "incrementDeposit", strategy = "increment")
    private Long id;

    @NotBlank
    @Column(unique=true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @NotNull
    @Column(name="is_third_party")
    private Boolean isThirdParty;

    @ManyToOne
    @JoinColumn(name = "subsidary_id")
    private Subsidary subsidary;

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

    public Boolean getThirdParty() {
        return isThirdParty;
    }

    public void setThirdParty(Boolean thirdParty) {
        isThirdParty = thirdParty;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Subsidary getSubsidary() {
        return subsidary;
    }

    public void setSubsidary(Subsidary subsidary) {
        this.subsidary = subsidary;
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
