package xyz.mobcoder.zyfra.ui.regex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import xyz.mobcoder.zyfra.App;
import xyz.mobcoder.zyfra.R;
import xyz.mobcoder.zyfra.adapter.MacAdapter;
import xyz.mobcoder.zyfra.arch.regex.RegexContract;
import xyz.mobcoder.zyfra.arch.regex.RegexPresenter;
import xyz.mobcoder.zyfra.databinding.FragmentRegexBinding;
import xyz.mobcoder.zyfra.models.MacModel;

public class RegexFragment extends Fragment implements RegexContract.View {
    FragmentRegexBinding binding;

    MacAdapter adapter;

    @Inject
    RegexPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getINSTANCE().getAppComponent().inject(this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_regex, container,false);
        presenter.attach(this);
        presenter.onCheckMac(requireContext());
        return binding.getRoot();
    }

    @Override
    public void checkResult(List<String> models) {
        adapter = new MacAdapter(models);
        binding.rvList.setAdapter(adapter);
    }

}