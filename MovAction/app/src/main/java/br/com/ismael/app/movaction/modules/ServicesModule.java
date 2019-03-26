package br.com.ismael.app.movaction.modules;


import br.com.ismael.app.movaction.services.ApiService;
import br.com.ismael.app.movaction.services.FilmesService;
import br.com.ismael.app.movaction.services.ImagemService;
import br.com.ismael.app.movaction.services.contracts.IApiService;
import br.com.ismael.app.movaction.services.contracts.IFilmesService;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {

    @Provides
    public IApiService obterApiService() {
        return new ApiService();
    }

    @Provides
    public IImagemService obterImageService() {
        return new ImagemService();
    }

    @Provides
    public IFilmesService obterFilmeService(IApiService apiService){
        return new FilmesService(apiService);
    }
}
