package stock.modules.product.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateProductDto {

    Long id;

    @NotBlank
    String name;

    @NotNull
    String unitMeasure;

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

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }
}