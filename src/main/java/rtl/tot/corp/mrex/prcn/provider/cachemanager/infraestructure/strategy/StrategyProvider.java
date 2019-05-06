package rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure.strategy;

import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.Event;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model.Provider;

public interface StrategyProvider {
    void persistProvider(Provider provider, Event event);
}
