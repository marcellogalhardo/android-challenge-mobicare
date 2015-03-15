package br.com.mobicare.viajabessa.services;

import br.com.mobicare.viajabessa.utils.DeviceHelper;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public final class ServiceFactory {

    private ServiceFactory() {}

    public static PacoteService criarPacoteService() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("User-Agent", DeviceHelper.getInstance().toString());
                request.addHeader("Device-Version", DeviceHelper.getInstance().getVersion());
                request.addHeader("Device-Model", DeviceHelper.getInstance().getModel());
                request.addHeader("Device-Manufacturer", DeviceHelper.getInstance().getManufacturer());
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(PacoteService.URI)
                .setRequestInterceptor(requestInterceptor)
                .build();

        return restAdapter.create(PacoteService.class);
    }

}
