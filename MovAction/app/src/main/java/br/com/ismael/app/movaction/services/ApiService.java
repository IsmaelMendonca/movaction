package br.com.ismael.app.movaction.services;

import javax.inject.Inject;

import br.com.ismael.app.movaction.services.contracts.IApiService;
import br.com.ismael.app.movaction.singletons.ConfigurationsProperties;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiService implements IApiService {
    private static final String BASE_URL = ConfigurationsProperties.getInstance().getBaseUrl();
    final private Retrofit mRetrofit;

    @Inject
    public ApiService() {
        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public <T> T criarInstanciaApi(Class<T> provedor) {
        return mRetrofit.create(provedor);
    }
}
