package stock.modules.subsidary;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity(name = "subsidary")
@Table(name = "subsidary")
public class Subsidary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementSubsidary")
    @GenericGenerator(name = "incrementSubsidary", strategy = "increment")
    private Long id;

    @NotBlank(message="Name may not be blank")
    @Column(unique=true)
    private String name;

    @CreationTimestamp
    @Column(name="created_at", updatable = false, insertable = true)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="update_at")
    private LocalDateTime updateAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
