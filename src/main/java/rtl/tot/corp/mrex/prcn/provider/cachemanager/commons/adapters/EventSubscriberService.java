package rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.adapters;

import org.springframework.stereotype.Service;

import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.EventSubscriber;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.infraestructure.ASBToCosmosDBEventHandler;


@Service
public class EventSubscriberService {

    public EventSubscriberService(final EventSubscriber eventSubscriber,
                                  final ASBToCosmosDBEventHandler asbToCosmosDBEventHandler) {
        eventSubscriber.registerEventHandler(asbToCosmosDBEventHandler);
    }

}
