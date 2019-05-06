package rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.Event;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.EventHandler;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.events.EventType;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model.Provider;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure.strategy.CreateProvider;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure.strategy.UpdateProvider;

@Slf4j
@Component
public class ASBToCosmosDBEventHandler implements EventHandler {

    @Override
    public void processEvent(Event event) {


        ObjectMapper mapper = new ObjectMapper();

        Provider provider;
        try {

            provider = mapper.readValue(event.getMetadata(), Provider.class);

            if (event.getEventType().equals(EventType.PROVIDER_CREATED.toString())) {
                new CreateProvider().persistProvider(provider, event);
            }

            if (event.getEventType().equals(EventType.PROVIDER_UPDATED.toString())) {
                new UpdateProvider().persistProvider(provider, event);
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
