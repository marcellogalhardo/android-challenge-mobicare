package br.com.mobicare.viajabessa.utils;

public final class BusProvider {
    private static final MainThreadBus BUS = new MainThreadBus();

    public static MainThreadBus getInstance() {
        return BUS;
    }

    private BusProvider() {}
}