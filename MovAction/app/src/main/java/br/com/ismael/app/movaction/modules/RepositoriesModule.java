package br.com.ismael.app.movaction.modules;

import android.content.Context;

import javax.inject.Singleton;

import androidx.room.Room;
import br.com.ismael.app.movaction.repositories.AppRepository;
import br.com.ismael.app.movaction.repositories.contracts.IAppRepository;
import br.com.ismael.app.movaction.repositories.database.AppDatabase;
import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    private Context mContext;

    public RepositoriesModule(Context applicationContext) {
        mContext = applicationContext;
    }

    @Provides
    public Context obterContext() {
        return mContext;
    }

    @Provides
    public AppDatabase obterAppDatabase(Context applicationContext) {
        return Room.databaseBuilder(applicationContext,
                AppDatabase.class, "MovActionDb").build();
    }

    @Provides
    @Singleton
    public IAppRepository obterAppRepository(AppDatabase appDatabase) {
        return new AppRepository(appDatabase);
    }
}
