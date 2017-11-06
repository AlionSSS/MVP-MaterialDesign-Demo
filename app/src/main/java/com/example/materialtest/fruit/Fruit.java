package com.example.materialtest.fruit;

import android.view.MenuItem;

/**
 * Fruit interface
 *
 * @author ALion on 2017/6/28 20:08
 */

public interface Fruit {

    interface View {

        void setContent(int resId);

        void finishActivity();

        void showProgressDialog(boolean show);

    }

    interface Presenter {

        void start();

        void onOptionsItemSelected(MenuItem item);

    }

}
