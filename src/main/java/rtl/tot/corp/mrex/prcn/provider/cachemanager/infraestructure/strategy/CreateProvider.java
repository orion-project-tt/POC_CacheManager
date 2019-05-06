package rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.Event;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.events.ProviderIntegrationEvent;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model.Provider;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.repository.ProviderRepository;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.adapters.EventPublisherService;

@Slf4j
public class CreateProvider implements StrategyProvider {

    @Autowired
    EventPublisherService publisher;

    ProviderRepository providerRepository;

    @Override
    public void persistProvider(Provider provider, Event event) {

        ProviderIntegrationEvent integrationEvent = new ProviderIntegrationEvent();

        integrationEvent.setRut(provider.getRut());
        integrationEvent.setName(provider.getName());
        integrationEvent.setCountry(provider.getCountry());

        publisher.publish(rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.events.EventType.PROVIDER_CREATED, integrationEvent);
        log.info("Persisting provider " + provider);
        providerRepository.save(provider);
        log.info("Published Provider Created" + event.getMetadata());



    }
}
