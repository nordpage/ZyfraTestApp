package xyz.mobcoder.zyfra.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.mobcoder.zyfra.arch.image.ImagePresenter;

@Module
public class ImageModule {
    @Singleton
    @Provides
    ImagePresenter providePresenter() { return new ImagePresenter(); }
}
