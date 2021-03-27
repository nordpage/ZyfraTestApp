package xyz.mobcoder.zyfra.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.mobcoder.zyfra.App;

@Module
public class AppModule {

    private final Context context;

    public AppModule(App app) {
        this.context = app.getApplicationContext();
    }

    @Singleton
    @Provides
    Context provideContext(){ return context; }

}
