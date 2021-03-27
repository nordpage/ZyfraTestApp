package xyz.mobcoder.zyfra.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.regex.*;

public class Extensions {

    public static <T> T cloneSerializableObject(@NonNull Object object) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous;
        Object cloned = null;
        try {
            ous = new ObjectOutputStream(baos);
            ous.writeObject(object);
            ous.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            cloned = (T) ois.readObject();
            System.out.println(object);
            System.out.println(cloned);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T)cloned;
    }

    public @Nullable
    static String getMAC(@Nullable String src) {
        if (src == null) {
            return "null";
        }


        String regex = "^([0-9A-Fa-f]{2}[:-])"
                + "{5}([0-9A-Fa-f]{2})|"
                + "([0-9a-fA-F]{4}\\."
                + "[0-9a-fA-F]{4}\\."
                + "[0-9a-fA-F]{4})$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(src);

        StringBuffer buf = new StringBuffer();

        if (m.matches()) {
            String output = src.replaceAll("[-.:]", "").toUpperCase();
            buf.append(output);
        } else buf.append("null");
        return buf.toString();
    }

    public @Nullable
    static Bitmap getBitmapFromFile(@Nullable File file) {
        Bitmap b = null;
        try {
            b = BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return b;
    }


    public static void copyAssets(Context context, String path, String fileName) {
        File image = new File(path);
        if (!image.isDirectory() && !image.exists()) {
            OutputStream myOutput = null;
            try {
                myOutput = new FileOutputStream(path);
                byte[] buffer = new byte[1024];
                int length;
                InputStream myInput = context.getAssets().open(fileName);
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myInput.close();
                myOutput.flush();
                myOutput.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
