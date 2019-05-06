package rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.Event;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.events.ProviderIntegrationEvent;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model.Provider;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.repository.ProviderRepository;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.adapters.EventPublisherService;

import java.util.Optional;


@Slf4j
public class UpdateProvider implements StrategyProvider {

    @Autowired
    EventPublisherService publisher;

    ProviderRepository providerRepository;

    @Override
    public void persistProvider(Provider provider, Event event) {

        log.info("Updating provider " + provider);

        Optional<Provider> providerObject = providerRepository.findById(event.getEntityId());

        if (providerObject.isPresent()) {

            Provider providerFromDB = providerObject.get();
            providerFromDB.setCountry(provider.getCountry());
            providerFromDB.setName(provider.getName());
            providerFromDB.setRut(provider.getRut());
            providerRepository.save(providerFromDB);
            ProviderIntegrationEvent integrationEvent = new ProviderIntegrationEvent();

            integrationEvent.setCountry(provider.getCountry());
            integrationEvent.setName(provider.getName());
            integrationEvent.setRut(provider.getRut());

            publisher.publish(rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.events.EventType.PROVIDER_UPDATED, integrationEvent);
            log.info("Published Provider updated" + event.getMetadata());
        } else {
            log.info("Provider not found to update" + event.getMetadata());
        }


    }
}
