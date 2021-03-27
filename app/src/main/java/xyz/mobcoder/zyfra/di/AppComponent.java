package xyz.mobcoder.zyfra.di;

import javax.inject.Singleton;

import dagger.Component;
import xyz.mobcoder.zyfra.arch.clone.ClonePresenter;
import xyz.mobcoder.zyfra.arch.regex.RegexPresenter;
import xyz.mobcoder.zyfra.di.modules.AppModule;
import xyz.mobcoder.zyfra.di.modules.CloneModule;
import xyz.mobcoder.zyfra.di.modules.ImageModule;
import xyz.mobcoder.zyfra.di.modules.RegexModule;
import xyz.mobcoder.zyfra.ui.clone.CloneFragment;
import xyz.mobcoder.zyfra.ui.image.ImageFragment;
import xyz.mobcoder.zyfra.ui.regex.RegexFragment;

@Singleton
@Component(modules = {AppModule.class, CloneModule.class, RegexModule.class, ImageModule.class})
public interface AppComponent {
    void inject(CloneFragment fragment);
    void inject(RegexFragment fragment);
    void inject(ImageFragment fragment);
}
