package br.com.ismael.app.movaction.services;

import javax.inject.Inject;

import br.com.ismael.app.movaction.apis.ITheMovieDbApi;
import br.com.ismael.app.movaction.models.MaisPopulares;
import br.com.ismael.app.movaction.services.callbacks.MaisPopularesCallback;
import br.com.ismael.app.movaction.services.contracts.IApiService;
import br.com.ismael.app.movaction.services.contracts.IFilmesService;
import br.com.ismael.app.movaction.singletons.ConfigurationsProperties;
import retrofit2.Call;

public class FilmesService implements IFilmesService {
    private IApiService mApiService;

    @Inject
    public FilmesService(IApiService apiService) {
        mApiService = apiService;
    }

    public void obterMaisPopulares(int pagina, MaisPopularesCallback callback) {
        Call<MaisPopulares> call = mApiService
                .criarInstanciaApi(ITheMovieDbApi.class)
                .listarFilmesPopulares(
                        ConfigurationsProperties.getInstance().getApiKey(),
                        "pt-BR",
                        pagina);

        call.enqueue(callback);
    }
}
