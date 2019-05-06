package rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event;

@FunctionalInterface
public interface EventHandler {
    void processEvent(final Event event);
}
