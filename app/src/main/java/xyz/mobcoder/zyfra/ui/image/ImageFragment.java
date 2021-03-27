package xyz.mobcoder.zyfra.ui.image;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.io.File;

import javax.inject.Inject;

import xyz.mobcoder.zyfra.App;
import xyz.mobcoder.zyfra.R;
import xyz.mobcoder.zyfra.arch.image.ImageContract;
import xyz.mobcoder.zyfra.arch.image.ImagePresenter;
import xyz.mobcoder.zyfra.databinding.FragmentImageBinding;

public class ImageFragment extends Fragment implements ImageContract.View {

    FragmentImageBinding binding;

    @Inject
    ImagePresenter presenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getINSTANCE().getAppComponent().inject(this);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        presenter.attach(this);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image, container, false);
        binding.setImageFragment(this);
        return binding.getRoot();
    }

    public void onClickEvent() {
        File file = new File(App.getPath());
        presenter.getImage(file);
    }


    @Override
    public void showBitmap(Bitmap bitmap) {
        binding.picture.setImageBitmap(bitmap);
    }


}