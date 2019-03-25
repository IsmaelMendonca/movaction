package br.com.ismael.app.movaction.services.contracts;

import br.com.ismael.app.movaction.models.DetalheFilme;
import br.com.ismael.app.movaction.models.MaisPopulares;
import br.com.ismael.app.movaction.services.callbacks.GenericCallback;

public interface IFilmesService {
    void obterMaisPopulares(int pagina, GenericCallback<MaisPopulares> callback);
    void detalharFilme(int id, GenericCallback<DetalheFilme> callback);


}
