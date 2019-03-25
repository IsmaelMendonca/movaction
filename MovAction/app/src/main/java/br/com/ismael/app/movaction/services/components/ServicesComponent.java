package br.com.ismael.app.movaction.services.components;

import javax.inject.Singleton;

import br.com.ismael.app.movaction.activities.DetailActivity;
import br.com.ismael.app.movaction.activities.MainActivity;
import br.com.ismael.app.movaction.adapters.FilmeAdapter;
import br.com.ismael.app.movaction.services.contracts.IFilmesService;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import br.com.ismael.app.movaction.services.modules.ServicesModule;
import dagger.Component;

@Singleton
@Component(modules = ServicesModule.class)
public interface ServicesComponent {
    IFilmesService obterFilmesService();
    IImagemService obterImagemService();

    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);
    void inject(FilmeAdapter filmeAdapter);
}
