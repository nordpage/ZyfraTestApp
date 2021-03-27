package xyz.mobcoder.zyfra.arch.regex;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyz.mobcoder.zyfra.R;
import xyz.mobcoder.zyfra.models.MacModel;
import xyz.mobcoder.zyfra.utils.Extensions;

public class RegexPresenter implements RegexContract.Presenter {

    private RegexContract.View view;

    @Override
    public void onCheckMac(Context context) {
        List<String> macList = Arrays.asList(context.getResources().getStringArray(R.array.macAddress));
        view.checkResult(macList);
    }

    @Override
    public void attach(RegexContract.View view) {
        this.view = view;
    }
}
