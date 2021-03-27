package xyz.mobcoder.zyfra.arch.regex;

import android.content.Context;

import java.util.List;

import xyz.mobcoder.zyfra.arch.base.BaseContract;

public class RegexContract {

    public interface View extends BaseContract.View {
        void checkResult(List<String> models);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void onCheckMac(Context context);
    }
}
