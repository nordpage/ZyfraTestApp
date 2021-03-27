package xyz.mobcoder.zyfra.arch.clone;

import xyz.mobcoder.zyfra.arch.base.BaseContract;

public class CloneContract {

    public interface View extends BaseContract.View {
        <T> void showClonedObject(T object);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        <T> void onCloneObject(T object);
    }
}
