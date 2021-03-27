package xyz.mobcoder.zyfra.arch.image;

import android.graphics.Bitmap;

import java.io.File;

import xyz.mobcoder.zyfra.arch.base.BaseContract;

public class ImageContract {

    public interface View extends BaseContract.View {
        void showBitmap(Bitmap bitmap);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getImage(File file);
    }

}
