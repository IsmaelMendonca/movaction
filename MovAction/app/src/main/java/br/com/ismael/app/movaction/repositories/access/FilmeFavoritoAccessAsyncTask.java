package br.com.ismael.app.movaction.repositories.access;

import android.os.AsyncTask;

import br.com.ismael.app.movaction.repositories.dao.FilmeFavoritoDao;
import br.com.ismael.app.movaction.repositories.entities.FilmeFavorito;
import br.com.ismael.app.movaction.repositories.enums.FilmeFavoritoEnum;

public class FilmeFavoritoAccessAsyncTask extends AsyncTask<Object, Void, FilmeFavoritoResult> {

    final private FilmeFavoritoDao mDao;
    final private FilmeFavorito mFilme;
    final private IAccessCallback mCallback;

    public FilmeFavoritoAccessAsyncTask(
            FilmeFavoritoDao dao,
            FilmeFavorito filme,
            IAccessCallback callback) {
        mDao = dao;
        mFilme = filme;
        mCallback = callback;
    }

    @Override
    protected FilmeFavoritoResult doInBackground(Object... parametros) {
        if(mFilme == null || mDao == null)
            return null;

        FilmeFavoritoEnum filmeEnum = FilmeFavoritoEnum.none;

        if(parametros.length == 1) {
            filmeEnum = (FilmeFavoritoEnum) parametros[0];
        }

        FilmeFavoritoResult result;

        switch (filmeEnum) {
            case insert:
                mDao.insert(mFilme);
                return null;
            case delete:
                mDao.delete(mFilme);
                return null;
            case findByFilmeId:
                result = new FilmeFavoritoResult();
                result.setFilmeFavorito(mDao.findByFilmeId(mFilme.idFilme));
                return result;
            case getAll:
                result = new FilmeFavoritoResult();
                result.setListaFilmeFavorito(mDao.getAll());
                return  result;
            default:
                return null;

        }
    }

    @Override
    protected void onPostExecute(FilmeFavoritoResult filmeFavoritoResult) {
        mCallback.result(filmeFavoritoResult);
    }
}
