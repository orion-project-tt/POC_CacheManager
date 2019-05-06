package rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event;

@FunctionalInterface
public interface EventSubscriber {
    boolean registerEventHandler(EventHandler eventHandler);
}
