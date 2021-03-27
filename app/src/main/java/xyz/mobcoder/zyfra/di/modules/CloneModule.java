package xyz.mobcoder.zyfra.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.mobcoder.zyfra.arch.clone.ClonePresenter;

@Module
public class CloneModule {

    @Singleton
    @Provides
    ClonePresenter providePresenter() {
        return new ClonePresenter();
    }
}
