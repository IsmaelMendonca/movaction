package br.com.ismael.app.movaction.components;

import javax.inject.Singleton;

import br.com.ismael.app.movaction.activities.DetailActivity;
import br.com.ismael.app.movaction.activities.MainActivity;
import br.com.ismael.app.movaction.adapters.FilmeAdapter;
import br.com.ismael.app.movaction.modules.RepositoriesModule;
import br.com.ismael.app.movaction.modules.ServicesModule;
import br.com.ismael.app.movaction.repositories.contracts.IAppRepository;
import br.com.ismael.app.movaction.services.contracts.IFilmesService;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import dagger.Component;

@Singleton
@Component(modules = {RepositoriesModule.class, ServicesModule.class})
public interface AppComponent {
    IAppRepository obterAppRepository();
    IFilmesService obterFilmesService();
    IImagemService obterImagemService();

    void inject(DetailActivity detailActivity);
    void inject(MainActivity mainActivity);
    void inject(FilmeAdapter filmeAdapter);
}
