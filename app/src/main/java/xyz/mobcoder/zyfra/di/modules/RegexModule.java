package xyz.mobcoder.zyfra.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.mobcoder.zyfra.arch.regex.RegexPresenter;

@Module
public class RegexModule {

    @Singleton
    @Provides
    RegexPresenter providePresenter() { return new RegexPresenter(); }
}
