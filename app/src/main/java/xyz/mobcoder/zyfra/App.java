package xyz.mobcoder.zyfra;

import android.app.Application;

import java.io.File;

import xyz.mobcoder.zyfra.di.AppComponent;
import xyz.mobcoder.zyfra.di.DaggerAppComponent;
import xyz.mobcoder.zyfra.di.modules.AppModule;
import xyz.mobcoder.zyfra.utils.Extensions;

public class App extends Application {
    private AppComponent appComponent;
    private static App INSTANCE;
    private String fileName = "image.jpg";
    private static String path;

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        return appComponent;
    }

    public static App getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        path = this.getFilesDir().getPath()+ File.separator+fileName;
        INSTANCE = this;
        Extensions.copyAssets(this, path, fileName);
    }

    public static String getPath() {
        return path;
    }
}
