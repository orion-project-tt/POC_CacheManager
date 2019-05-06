package rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event;

public interface EventConverter<T> {
    T toMessage(Event event);
    Event fromMessage(T message);
}
