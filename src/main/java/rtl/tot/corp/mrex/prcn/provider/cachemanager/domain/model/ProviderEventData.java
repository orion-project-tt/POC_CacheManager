package rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public abstract class ProviderEventData {
    private final ProviderType eventType;

    @JsonIgnore
    ProviderEventData(ProviderType eventType) {
        this.eventType = eventType;
    }
}
