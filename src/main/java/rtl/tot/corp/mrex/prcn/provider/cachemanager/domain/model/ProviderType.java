package rtl.tot.corp.mrex.prcn.provider.cachemanager.domain.model;

import java.util.Arrays;

public enum ProviderType {

    CREATE("createFolio"),
    UPDATE("updateFolio");

    private final String text;

    ProviderType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static ProviderType parse(String textValue) {
        return Arrays.stream(ProviderType.values())
                .filter(enumValue ->
                        enumValue.text.equalsIgnoreCase(textValue))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("unknown value: " +
                                textValue));
    }
}
