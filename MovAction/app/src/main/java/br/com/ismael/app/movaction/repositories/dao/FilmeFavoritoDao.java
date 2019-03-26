package br.com.ismael.app.movaction.repositories.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import br.com.ismael.app.movaction.repositories.entities.FilmeFavorito;

@Dao
public interface FilmeFavoritoDao {
    @Query("SELECT * FROM filmefavorito")
    List<FilmeFavorito> getAll();

    @Query("SELECT * FROM filmefavorito WHERE id_filme = :id LIMIT 1")
    FilmeFavorito findByFilmeId(int id);

    @Delete
    void delete(FilmeFavorito filmeFavorito);

    @Insert
    void insert(FilmeFavorito filmeFavorito);
}
