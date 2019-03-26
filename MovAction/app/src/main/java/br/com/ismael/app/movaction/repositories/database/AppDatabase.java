package br.com.ismael.app.movaction.repositories.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import br.com.ismael.app.movaction.repositories.dao.FilmeFavoritoDao;
import br.com.ismael.app.movaction.repositories.entities.FilmeFavorito;

@Database(entities = {FilmeFavorito.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FilmeFavoritoDao filmeFavoritoDao();
}
