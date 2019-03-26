package br.com.ismael.app.movaction.repositories.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FilmeFavorito {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "id_filme")
    public int idFilme;

    @ColumnInfo(name = "nome_filme")
    public String nomeFilme;

    public FilmeFavorito(int idFilme) {
        this.idFilme = idFilme;
    }

    public FilmeFavorito() {
    }
}
