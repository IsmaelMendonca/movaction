package br.com.ismael.app.movaction.repositories;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.ismael.app.movaction.repositories.contracts.IAppRepository;
import br.com.ismael.app.movaction.repositories.database.AppDatabase;

@Singleton
public class AppRepository implements IAppRepository {
    private final AppDatabase mDB;

    @Inject
    public AppRepository(AppDatabase db) {
        mDB = db;
    }

    public AppDatabase getDB() {
        return mDB;
    }
}
