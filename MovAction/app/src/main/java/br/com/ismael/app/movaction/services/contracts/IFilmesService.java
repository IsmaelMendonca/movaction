package br.com.ismael.app.movaction.services.contracts;

import br.com.ismael.app.movaction.services.callbacks.MaisPopularesCallback;

public interface IFilmesService {
    void obterMaisPopulares(int pagina, MaisPopularesCallback callback);
}
