package rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.events;

public enum EventType {
    PROVIDER_CREATED("providerCreated"),
    PROVIDER_UPDATED("providerUpdated"),
    GET_PROVIDER("getProvider");
    private final String name;

    EventType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

