package br.com.ismael.app.movaction;

import android.app.Application;

import br.com.ismael.app.movaction.services.components.DaggerServicesComponent;
import br.com.ismael.app.movaction.services.components.ServicesComponent;
import br.com.ismael.app.movaction.singletons.ConfigurationsProperties;

public class MainApplication extends Application {
    private static ServicesComponent servicesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ConfigurationsProperties.init(getApplicationContext());
        initDagger();
    }

    private void initDagger() {
        servicesComponent = DaggerServicesComponent.builder().build();
    }

    public static ServicesComponent getServicesComponent() {
        return servicesComponent;
    }
}
