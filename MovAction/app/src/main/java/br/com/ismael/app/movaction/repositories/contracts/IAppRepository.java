package br.com.ismael.app.movaction.repositories.contracts;

import br.com.ismael.app.movaction.repositories.database.AppDatabase;

public interface IAppRepository {
    AppDatabase getDB();
}
