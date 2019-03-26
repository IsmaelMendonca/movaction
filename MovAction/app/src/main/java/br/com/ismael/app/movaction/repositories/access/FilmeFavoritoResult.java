package br.com.ismael.app.movaction.repositories.access;

import java.util.List;

import br.com.ismael.app.movaction.repositories.entities.FilmeFavorito;

public class FilmeFavoritoResult implements IResult {
    private FilmeFavorito mFilmeFavorito;
    private List<FilmeFavorito> mListaFilmeFavorito;

    public FilmeFavorito getFilmeFavorito() {
        return mFilmeFavorito;
    }

    public void setFilmeFavorito(FilmeFavorito filmeFavorito) {
        mFilmeFavorito = filmeFavorito;
    }

    public List<FilmeFavorito> getListaFilmeFavorito() {
        return mListaFilmeFavorito;
    }

    public void setListaFilmeFavorito(List<FilmeFavorito> listaFilmeFavorito) {
        mListaFilmeFavorito = listaFilmeFavorito;
    }
}
