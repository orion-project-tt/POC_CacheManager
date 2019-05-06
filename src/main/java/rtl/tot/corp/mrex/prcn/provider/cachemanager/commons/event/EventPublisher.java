package rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event;

@FunctionalInterface
public interface EventPublisher {
    boolean publish(Event event);
}
