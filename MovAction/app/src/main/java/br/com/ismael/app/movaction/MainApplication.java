package br.com.ismael.app.movaction;

import android.app.Application;

import br.com.ismael.app.movaction.components.AppComponent;
import br.com.ismael.app.movaction.components.DaggerAppComponent;
import br.com.ismael.app.movaction.modules.RepositoriesModule;
import br.com.ismael.app.movaction.singletons.ConfigurationsProperties;

public class MainApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ConfigurationsProperties.init(getApplicationContext());
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .repositoriesModule(new RepositoriesModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
