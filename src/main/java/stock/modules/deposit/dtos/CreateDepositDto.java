package stock.modules.deposit.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateDepositDto {

    @NotBlank
    String name;

    @NotNull
    Boolean isThirdParty;

    @NotNull
    Long subsidaryId;

    @NotNull
    Long localId;

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

    public Long getSubsidaryId() {
        return subsidaryId;
    }

    public void setSubsidaryId(Long subsidaryId) {
        this.subsidaryId = subsidaryId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }
}