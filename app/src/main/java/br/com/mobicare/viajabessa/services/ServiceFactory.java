package br.com.mobicare.viajabessa.services;

import retrofit.RestAdapter;

public final class ServiceFactory {

    private ServiceFactory() {}

    public static PacoteService criarPacoteService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(PacoteService.URI)
                .build();

        return restAdapter.create(PacoteService.class);
    }

}
