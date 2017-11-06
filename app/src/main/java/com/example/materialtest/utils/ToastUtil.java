package com.example.materialtest.utils;

import android.widget.Toast;

import com.example.materialtest.global.MyApplication;

/**
 * 自定义Toast
 *
 * @author ALion
 */
public class ToastUtil {

    private static Toast toast;

    public static void show(String message) {
        if (toast == null) {
            toast = Toast.makeText(MyApplication.getContext(), message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

}
