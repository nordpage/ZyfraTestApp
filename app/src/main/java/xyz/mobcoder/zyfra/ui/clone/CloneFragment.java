package xyz.mobcoder.zyfra.ui.clone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import xyz.mobcoder.zyfra.App;
import xyz.mobcoder.zyfra.R;
import xyz.mobcoder.zyfra.arch.clone.CloneContract;
import xyz.mobcoder.zyfra.arch.clone.ClonePresenter;
import xyz.mobcoder.zyfra.databinding.FragmentCloneBinding;
import xyz.mobcoder.zyfra.models.TestModel;

public class CloneFragment extends Fragment implements CloneContract.View{

    FragmentCloneBinding binding;

    @Inject
    ClonePresenter presenter;
    TestModel model;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getINSTANCE().getAppComponent().inject(this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        presenter.attach(this);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_clone, container, false);
        binding.setCloneFragment(this);
        model = new TestModel("Рычаг", 15, true);
        binding.setOriginal(model);

        return binding.getRoot();
    }

    public void onClickEvent(TestModel model){
        presenter.onCloneObject(model);
    }

    @Override
    public <T> void showClonedObject(T object) {
        if (object instanceof TestModel) {
            binding.setCloned((TestModel) object);
        }
    }
}