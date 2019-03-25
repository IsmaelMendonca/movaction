package br.com.ismael.app.movaction.singletons;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationsProperties {
    private static final ConfigurationsProperties ourInstance = new ConfigurationsProperties();
    private static Properties mConfigurationProperty;
    private static String sBaseUrl;
    private static String sApiKey;
    private static String sBaseImageUrl;

    public static ConfigurationsProperties getInstance() {
        return ourInstance;
    }

    private ConfigurationsProperties() {
    }

    public static void init(Context context) {
        AssetsPropertyReader reader = new AssetsPropertyReader(context);
        mConfigurationProperty = reader.getProperties("configurations.properties");
        sBaseUrl = mConfigurationProperty.getProperty("base.url");
        sApiKey = mConfigurationProperty.getProperty("api.key");
        sBaseImageUrl = mConfigurationProperty.getProperty("base.image.url");
    }

    public static Properties getmConfigurationProperty() {
        return mConfigurationProperty;
    }

    public static void setmConfigurationProperty(Properties mConfigurationProperty) {
        ConfigurationsProperties.mConfigurationProperty = mConfigurationProperty;
    }

    public String getBaseUrl() {
        return sBaseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        ConfigurationsProperties.sBaseUrl = baseUrl;
    }

    public String getBaseImageUrl() {
        return sBaseImageUrl;
    }

    public void setBaseImageUrl(String baseUrl) {
        ConfigurationsProperties.sBaseImageUrl = baseUrl;
    }

    public String getApiKey() {
        return sApiKey;
    }

    public void setApiKey(String apiKey) {
        ConfigurationsProperties.sApiKey = apiKey;
    }

    static class AssetsPropertyReader {

        private static final String sTag = AssetsPropertyReader.class.getName();

        private Context mContext;
        private Properties mProperties;

        public AssetsPropertyReader(Context context) {
            mContext = context;
            mProperties = new Properties();
        }

        public Properties getProperties(String FileName) {

            try {
                AssetManager assetManager = mContext.getAssets();
                InputStream inputStream = assetManager.open(FileName);
                mProperties.load(inputStream);

            } catch (IOException e) {
                Log.e(sTag, e.getMessage());
            }

            return mProperties;
        }
    }
}
