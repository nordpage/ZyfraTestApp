package xyz.mobcoder.zyfra.arch.image;

import android.graphics.Bitmap;

import java.io.File;

import xyz.mobcoder.zyfra.utils.Extensions;

public class ImagePresenter implements ImageContract.Presenter {

    ImageContract.View view;

    @Override
    public void getImage(File file) {
        Bitmap bitmap = Extensions.getBitmapFromFile(file);
        view.showBitmap(bitmap);
    }

    @Override
    public void attach(ImageContract.View view) {
        this.view = view;
    }
}
