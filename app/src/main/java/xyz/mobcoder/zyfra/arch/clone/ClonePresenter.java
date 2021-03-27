package xyz.mobcoder.zyfra.arch.clone;

import xyz.mobcoder.zyfra.utils.Extensions;

public class ClonePresenter implements CloneContract.Presenter {

    private CloneContract.View view;

    @Override
    public <T> void onCloneObject(T object) {
        Object cloned = Extensions.cloneSerializableObject(object);
        view.showClonedObject(cloned);
    }

    @Override
    public void attach(CloneContract.View view) {
        this.view = view;
    }
}
